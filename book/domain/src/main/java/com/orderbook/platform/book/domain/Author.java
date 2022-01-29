package com.orderbook.platform.book.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.Assert;

@Builder
@Getter
@ToString
@EqualsAndHashCode
public class Author {
    private final Long id;
    private final String author;

    public Author(Long id, String author) {
        Assert.notNull(author, "author must not be null");
        if (author.isEmpty()) {
            throw new IllegalArgumentException("author must not be null");
        }else {
            this.author = author;
            this.id = id;
        }
    }
}
