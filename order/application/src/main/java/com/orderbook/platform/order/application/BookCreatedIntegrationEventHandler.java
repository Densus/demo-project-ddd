package com.orderbook.platform.order.application;

import com.orderbook.platform.book.integrationevents.BookCreatedIntegrationEvent;
import com.orderbook.platform.order.domain.BookView;
import com.orderbook.platform.order.domain.BookViewRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookCreatedIntegrationEventHandler {
    private final BookViewRepository bookViewRepository;

    @EventHandler
    public void handle(BookCreatedIntegrationEvent event) {
        bookViewRepository.save(
                BookView.create(
                        event.getIsbn(),
                        event.getBookPrice()
                )
        );
    }
}
