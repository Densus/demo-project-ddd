package com.orderbook.platform.book.application.impl;

import com.orderbook.platform.book.application.BookService;
import com.orderbook.platform.book.application.CreateBookVO;
import com.orderbook.platform.book.domain.BookAggregate;
import com.orderbook.platform.book.domain.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public String createBook(CreateBookVO bookVO) {
        bookRepository.save(
                BookAggregate.builder()
                .title(bookVO.getTitle())
                .description(bookVO.getDescription())
                .published_on(bookVO.getPublished_on())
                .publisher(bookVO.getPublisher())
                .org_price(bookVO.getOrg_price())
                .saveAuthor(bookVO.getAuthor())
                .build());

//        BookCreatedIntegrationEvent event = BookCreatedIntegrationEvent
//                .builder()
//                .email(newUser.getEmail().toString())
//                .firstName(newUser.getName().getFirstName())
//                .lastName(newUser.getName().getLastName())
//                .uid(newUser.getUid().toString())
//                .username(newUser.getUsername().toString())
//                .role(form.getRole().toString())
//                .build();
//        eventBus.publish(GenericEventMessage.asEventMessage(event));

        return "";
    }

//    @Override
//    @Transactional
//    public BookDto getBookDetailById(long id) {
//        BookAggregate book = bookRepository.findById(id);
//        return BookDto.from(book);
//    }
//
//    @Override
//    @Transactional
//    public BookDto getBookDetailByTitle(String title) {
//        BookAggregate book = bookRepository.findByTitle(new Title(title));
//        return BookDto.from(book);
//    }
}
