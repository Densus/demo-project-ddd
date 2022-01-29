package com.orderbook.platform.book.infrastructure;

import com.orderbook.platform.book.domain.Author;
import com.orderbook.platform.book.domain.BookAggregate;
import com.orderbook.platform.book.domain.BookRepository;
import com.orderbook.platform.book.domain.Title;
import com.orderbook.platform.common.domain.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class BookJpaRepository implements BookRepository {
    private final BookDao bookDao;
    private final AuthorDao authorDao;
    @Autowired
    public BookJpaRepository(BookDao bookDao,AuthorDao authorDao){
        this.bookDao = bookDao;
        this.authorDao = authorDao;
    }

    @Override
    public void save(BookAggregate bookEntity) {
        Book book = toDatabaseEntity(bookEntity);

        addAuthor(bookEntity, book);

        this.bookDao.save(book);
    }


    @Override
    public List<BookAggregate> getAllBook() {
        List<Book> books = this.bookDao.findAll();

        return toListDomainEntity(books);
    }

    @Override
    public List<BookAggregate> getAllBookByTitle(Title title) {
        List<Book> books = this.bookDao.getAllBookByTitle(title.getTitle());

        if (books != null) {
            return toListDomainEntity(books);
        }else {
            throw new ResourceNotFoundException("Book", "title", title);
        }
    }

    @Override
    public BookAggregate findById(Long id) {
        Book book = this.bookDao.findBookById(id);
        if (book != null) {
            return toDomainEntity(book);
        }else {
            throw new ResourceNotFoundException("Book", "id", id);
        }
    }

    @Override
    public void deleteById(Long id) {
        Book book = this.bookDao.findBookById(id);

        if (book != null) {
            this.bookDao.deleteById(id);
        }else {
            throw new ResourceNotFoundException("Book", "id", id);
        }
    }

    private static BookAggregate toDomainEntity(Book book) {
        if(book != null) {
            List<Author> authorList = book.getAuthors()
                    .stream()
                    .map(author -> new Author(author.getId(), author.getName()))
                    .collect(Collectors.toList());
            return new BookAggregate(book.getId(), book.getIsbn(), book.getTitle(), book.getDescription(),
                    book.getPublishedOn(), book.getPublisher(), book.getOrgPrice(), authorList);
        }

        return null;
    }

    private static List<BookAggregate> toListDomainEntity(List<Book> books) {
        List<BookAggregate> bookAggregates = new ArrayList<>();
        if(books != null) {
            for (Book book : books) {
                bookAggregates.add(toDomainEntity(book));
            }
            return bookAggregates;
        }

        return null;
    }

    private static Book toDatabaseEntity(BookAggregate bookEntity) {
        Long id = bookEntity.getId();
        String isbn = bookEntity.getIsbn();
        String title = bookEntity.getTitle().getTitle();
        String description = bookEntity.getDescription().getDescription();
        Date published_on = bookEntity.getPublished_on();
        String publisher = bookEntity.getPublisher().getPublisher();
        BigDecimal org_price = bookEntity.getOrg_price().getOrg_price();

        return new Book(id, isbn, title, description, published_on, publisher, org_price);
    }

    private void addAuthor(BookAggregate bookEntity, Book book) {
        for (Author author : bookEntity.getAuthor()) {
            Optional<com.orderbook.platform.book.infrastructure.Author> authorOpt = authorDao.findByName(author.getAuthor());
            if (authorOpt.isPresent()) {
                book.getAuthors().add(authorOpt.get());
            }else {
                com.orderbook.platform.book.infrastructure.Author entity = new com.orderbook.platform.book.infrastructure.Author();
                entity.setName(author.getAuthor());
                book.getAuthors().add(authorDao.saveAndFlush(entity));
            }
        }
    }
}
