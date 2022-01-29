package com.orderbook.platform.book.application;

import com.orderbook.platform.book.domain.BookAggregate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Value
@AllArgsConstructor
public class BookDto {
    private final Long id;

    private final String isbn;

    private final String title;

    private final String description;

    private final Date published_on;

    private final String publisher;

    private final BigDecimal org_price;

    private final List<String> author;

    public static BookDto from(BookAggregate book) {
        return BookDto.builder()
                .isbn(book.getIsbn())
                .id(book.getId())
                .title(book.getTitle().getTitle())
                .description(book.getDescription().getDescription())
                .published_on(book.getPublished_on())
                .publisher(book.getPublisher().getPublisher())
                .org_price(book.getOrg_price().getOrg_price())
                .author(book.getAuthor().stream().map(a -> a.getAuthor()).collect(Collectors.toList()))
                .build();
    }
}
