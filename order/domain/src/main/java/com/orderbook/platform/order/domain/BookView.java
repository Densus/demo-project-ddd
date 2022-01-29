package com.orderbook.platform.order.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
@AllArgsConstructor
public class BookView {
    private final Long id;

    private final String isbn;

    private final BigDecimal bookPrice;

    public static BookView create(String isbn, BigDecimal bookPrice) {
        return new BookView(null, isbn, bookPrice);
    }
}
