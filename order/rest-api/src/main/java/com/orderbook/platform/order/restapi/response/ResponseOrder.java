package com.orderbook.platform.order.restapi.response;

import com.orderbook.platform.order.application.OrderVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.util.Date;

@Builder
@Value
@AllArgsConstructor
public class ResponseOrder {
    private final Long id;

    private final Long bookId;

    private final String customerName;

    private final Date expectedDeliveryDate;

    private final Integer numBook;

    private final BigDecimal bookPrice;

    public static ResponseOrder from(OrderVO orderVO) {
        return ResponseOrder.builder()
                .id(orderVO.getId())
                .bookId(orderVO.getBookId())
                .customerName(orderVO.getCustomerName())
                .expectedDeliveryDate(orderVO.getExpectedDeliveryDate())
                .numBook(orderVO.getNumBook())
                .bookPrice(orderVO.getBookPrice())
                .build();
    }
}
