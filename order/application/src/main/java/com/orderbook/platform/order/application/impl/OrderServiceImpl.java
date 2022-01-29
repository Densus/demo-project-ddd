package com.orderbook.platform.order.application.impl;

import com.orderbook.platform.order.application.OrderService;
import com.orderbook.platform.order.application.OrderVO;
import com.orderbook.platform.order.domain.OrderAggregate;
import com.orderbook.platform.order.domain.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    @Transactional
    public String createOrder(OrderVO orderVO) {
        orderRepository.createOrder(
                OrderAggregate.builder()
                        .bookId(orderVO.getBookId())
//                        .bookPrice(orderVO.getBookPrice())
                        .numBook(orderVO.getNumBook())
                        .customerName(orderVO.getCustomerName())
                        .expectedDeliveryDate(orderVO.getExpectedDeliveryDate())
                        .build());
        return "";
    }

    @Override
    @Transactional
    public List<OrderVO> getAllOrder() {
        List<OrderAggregate> order = orderRepository.getAllOrder();
        List<OrderVO> orderVOS = new ArrayList<>();
        for (OrderAggregate orderAggregate : order) {
            orderVOS.add(OrderVO.from(orderAggregate));
        }
        return orderVOS;
    }

}
