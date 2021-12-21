package com.orderbook.platform.book.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.Assert;

@Getter
@ToString
@EqualsAndHashCode
public class Publisher {
    private final String publisher;

    public Publisher(String publisher) {
        this.publisher = publisher;
    }

    private void validate(String publisher){
        Assert.notNull(publisher, "publisher must not be null");
    }
}
