package com.orderbook.platform.order.domain;

import java.util.List;

public interface OrderRepository {
    void createOrder(OrderAggregate orderAggregate);
    List<OrderAggregate> getAllOrder();
}
