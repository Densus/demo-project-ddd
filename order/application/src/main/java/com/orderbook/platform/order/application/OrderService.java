package com.orderbook.platform.order.application;

import java.util.List;

public interface OrderService {
    public String createOrder(OrderVO orderVO);
    List<OrderVO> getAllOrder();
}
