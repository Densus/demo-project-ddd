package com.orderbook.platform.book.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.Assert;

@Getter
@ToString
@EqualsAndHashCode
public class Title {
    private final String title;

    public Title(String title) {
        this.validate(title);

        this.title = title;
    }

    private void validate(String title){
        Assert.notNull(title, "title must not be null");
    }
}
