package com.orderbook.platform.book.integrationevents;

import com.orderbook.platform.common.integration.event.Event;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
public class BookCreatedIntegrationEvent implements Event {
//    Long id;
    String isbn;
    BigDecimal bookPrice;
}
