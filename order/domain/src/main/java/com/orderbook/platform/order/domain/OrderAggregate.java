package com.orderbook.platform.order.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Date;

@Builder
@Getter
@AllArgsConstructor
public class OrderAggregate {
    private final Long id;

    private final Long bookId;

    private final String customerName;

    private final Date expectedDeliveryDate;

    private final Integer numBook;

    private final BigDecimal bookPrice;
}
