package com.orderbook.platform.order.application;

import com.orderbook.platform.order.domain.OrderAggregate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.stream.Collectors;

@Builder
@Data
@AllArgsConstructor
public class OrderVO {
    private final Long id;

    private final Long bookId;

    private final String customerName;

    private final Date expectedDeliveryDate;

    private final Integer numBook;

    private final BigDecimal bookPrice;

    public static OrderVO from(OrderAggregate orderAggregate) {
        return OrderVO.builder()
                .id(orderAggregate.getId())
                .bookId(orderAggregate.getBookId())
                .customerName(orderAggregate.getCustomerName())
                .expectedDeliveryDate(orderAggregate.getExpectedDeliveryDate())
                .numBook(orderAggregate.getNumBook())
                .bookPrice(orderAggregate.getBookPrice())
                .build();
    }
}
