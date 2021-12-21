package com.orderbook.platform.book.infrastructure;

import com.orderbook.platform.book.domain.Author;
import com.orderbook.platform.book.domain.BookAggregate;
import com.orderbook.platform.book.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookJpaRepository implements BookRepository {
    private BookDao bookDao;

    @Autowired
    public BookJpaRepository(BookDao bookDao){
        this.bookDao = bookDao;
    }

    @Override
    public void save(BookAggregate bookEntity) {
        this.bookDao.save(toDatabaseEntity(bookEntity));
    }

//    @Override
//    public List<BookAggregate> getAllBook() {
//        return null;
//    }
//
//    @Override
//    public BookAggregate findByTitle(Title title) {
//        Book book = this.bookDao.findByTitle(title.toString());
//
//        return toDomainEntity(book);
//    }
//
//    @Override
//    public BookAggregate findById(long id) {
//        Book book = this.bookDao.findById(id);
//
//        return toDomainEntity(book);
//    }
//
//    @Override
//    public void deleteById(long id) {

//    }

    private static BookAggregate toDomainEntity(Book book) {
        if(book != null) {
            List<Author> authorList = book.getAuthors()
                    .stream()
                    .map(author -> new Author(author.getName()))
                    .collect(Collectors.toList());
            return new BookAggregate(book.getId(), book.getTitle(), book.getDescription(),
                    book.getPublishedOn(), book.getPublisher(), book.getOrgPrice(), authorList);
        }

        return null;
    }

    private static Book toDatabaseEntity(BookAggregate bookEntity) {
        Long id = bookEntity.getId();
        String title = bookEntity.getTitle().toString();
        String description = bookEntity.getDescription().toString();
        Date published_on = bookEntity.getPublished_on();
        String publisher = bookEntity.getPublisher().toString();
        BigDecimal org_price = bookEntity.getOrg_price().getOrg_price();
//        String author = bookEntity.getAuthor().toString();

        Book book = new Book(id, title, description, published_on, publisher, org_price);
        for(Author author : bookEntity.getAuthor()) {
            book.saveAuthor(author.toString());
        }

        return book;
    }
}
