package com.orderbook.platform.book.infrastructure.config;

import com.orderbook.platform.book.application.BookService;
import com.orderbook.platform.book.application.impl.BookServiceImpl;
import com.orderbook.platform.book.domain.AuthorRepository;
import com.orderbook.platform.book.domain.BookRepository;
import org.axonframework.eventhandling.EventBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BeanConfig {

//    @Bean
    BookService bookService(final BookRepository bookRepository, final AuthorRepository authorRepository, final EventBus eventBus) {
        return new BookServiceImpl(bookRepository, authorRepository, eventBus);
    }

//    @Bean
//    BookService bookService(final BookRepository bookRepository) {
//        return new BookServiceImpl(bookRepository);
//    }
}
