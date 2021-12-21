package com.orderbook.platform.book.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.Assert;

@Getter
@ToString
@EqualsAndHashCode
public class Author {
    private final String author;

    public Author(String author) {
        Assert.notNull(author, "author must not be null");
        this.author = author;
    }
}
