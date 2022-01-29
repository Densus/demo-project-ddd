package com.orderbook.platform.book.application.impl;

import com.orderbook.platform.book.application.BookDto;
import com.orderbook.platform.book.application.BookService;
import com.orderbook.platform.book.application.CreateBookVO;
import com.orderbook.platform.book.domain.*;
import com.orderbook.platform.book.integrationevents.BookCreatedIntegrationEvent;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventhandling.GenericEventMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final EventBus eventBus;

    @Override
    @Transactional
    public String createBook(CreateBookVO bookVO) {
        List<Author> authors = new ArrayList<>();

        for (String name : bookVO.getAuthor()) {
            Author author = new Author(null, name);
            authors.add(author);
        }
        final BookAggregate newBook = BookAggregate.builder()
                .isbn(bookVO.getIsbn())
                .title(bookVO.getTitle())
                .description(bookVO.getDescription())
                .published_on(bookVO.getPublished_on())
                .publisher(bookVO.getPublisher())
                .org_price(bookVO.getOrg_price())
                .authors(authors)
                .build();
        bookRepository.save(newBook);

        BookCreatedIntegrationEvent event = BookCreatedIntegrationEvent
                .builder()
                .isbn(newBook.getIsbn())
                .bookPrice(newBook.getOrg_price().getOrg_price())
                .build();
        eventBus.publish(GenericEventMessage.asEventMessage(event));

        return "";
    }

    @Override
    @Transactional
    public BookDto updateBookById(CreateBookVO bookVO, Long id) {
        List<Author> authors = new ArrayList<>();

        for (String name : bookVO.getAuthor()) {
            Author author = new Author(null, name);
            authors.add(author);
        }

        BookAggregate bookAggregate = bookRepository.findById(id);
        bookAggregate.changeIsbn(bookVO.getIsbn());
        bookAggregate.changeTitle(bookVO.getTitle());
        bookAggregate.changeDescription(bookVO.getDescription());
        bookAggregate.changePublisher(bookVO.getPublisher());
        bookAggregate.changePublished_on(bookVO.getPublished_on());
        bookAggregate.changeOrg_price(bookVO.getOrg_price());
        bookAggregate.setAuthor(authors);
        bookRepository.save(bookAggregate);

        return BookDto.from(bookAggregate);
    }

    @Override
    @Transactional
    public List<BookDto> getAllBook() {
        List<BookAggregate> book = bookRepository.getAllBook();
        List<BookDto> bookDtoList = new ArrayList<>();
        for (BookAggregate bookAggregate : book) {
            bookDtoList.add(BookDto.from(bookAggregate));
        }
        return bookDtoList;
    }

    @Override
    @Transactional
    public BookDto getBookDetailById(Long id) {
        BookAggregate book = bookRepository.findById(id);
        return BookDto.from(book);
    }

    @Override
    @Transactional
    public List<BookDto> getAllBookByTitle(String title) {
        List<BookAggregate> book = bookRepository.getAllBookByTitle(new Title(title));
        List<BookDto> bookDtoList = new ArrayList<>();
        for (BookAggregate bookAggregate : book) {
            bookDtoList.add(BookDto.from(bookAggregate));
        }
        return bookDtoList;
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
