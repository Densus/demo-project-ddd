package com.orderbook.platform.book.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.Assert;

@Getter
@ToString
@EqualsAndHashCode
public class Description {
    private final String description;

    public Description(String description) {
        this.validate(description);
        this.description = description;
    }

    private void validate(String description) {
        Assert.notNull(description, "title must not be null");
    }
}
