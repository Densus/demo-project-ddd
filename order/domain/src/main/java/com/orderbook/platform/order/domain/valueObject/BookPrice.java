package com.orderbook.platform.order.domain.valueObject;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.Assert;

import java.math.BigDecimal;

@Builder
@Getter
@ToString
@EqualsAndHashCode
public class BookPrice {
    private final BigDecimal bookPrice;

    public BookPrice(BigDecimal bookPrice) {
        Assert.notNull(bookPrice, "amount must not be null");
        if (bookPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("amount must be greater than or equal to zero");
        }else {
            this.bookPrice = bookPrice;
        }
    }
}
