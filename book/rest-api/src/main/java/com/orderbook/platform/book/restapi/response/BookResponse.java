package com.orderbook.platform.book.restapi.response;

import com.orderbook.platform.book.application.BookDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Builder
@Value
@AllArgsConstructor
public class BookResponse {
    private final Long id;

    private final String title;

    private final String description;

    private final Date published_on;

    private final String publisher;

    private final BigDecimal org_price;

    private final List<String> author;

    public static BookResponse from(BookDto book) {
        return BookResponse.builder()
                .id(book.getId())
                .title(book.getTitle())
                .description(book.getDescription())
                .published_on(book.getPublished_on())
                .publisher(book.getPublisher())
                .org_price(book.getOrg_price())
                .author(book.getAuthor())
                .build();
    }
}
