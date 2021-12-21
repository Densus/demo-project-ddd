package com.orderbook.platform.book.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.Assert;

import java.math.BigDecimal;

@Getter
@ToString
@EqualsAndHashCode
public class Price {
    private final BigDecimal org_price;

    public Price(BigDecimal org_price) {
        Assert.notNull(org_price, "amount must not be null");
        if(org_price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("amount must be greater than or equal to zero");
        }
        this.org_price = org_price;
    }
}
