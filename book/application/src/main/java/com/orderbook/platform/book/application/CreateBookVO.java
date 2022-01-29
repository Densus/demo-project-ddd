package com.orderbook.platform.book.application;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
public class CreateBookVO {
    private final String isbn;

    private final String title;

    private final String description;

    private final Date published_on;

    private final String publisher;

    private final BigDecimal org_price;

    private final List<String> author;
}
