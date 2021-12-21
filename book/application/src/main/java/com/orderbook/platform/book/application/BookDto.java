package com.orderbook.platform.book.application;

import com.orderbook.platform.book.domain.BookAggregate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.util.Date;

@Builder
@Value
@AllArgsConstructor
public class BookDto {
    private final long id;

    private final String title;

    private final String description;

    private final Date published_on;

    private final String publisher;

    private final BigDecimal org_price;

    private final String author;

    public static BookDto from(BookAggregate book) {
        return BookDto.builder()
                .id(book.getId())
                .title(book.getTitle().toString())
                .description(book.getDescription().toString())
                .published_on(book.getPublished_on())
                .publisher(book.getPublisher().toString())
                .org_price(book.getOrg_price().getOrg_price())
                .author(book.getAuthor().toString())
                .build();
    }
}
