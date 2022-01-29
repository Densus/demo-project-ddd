package com.orderbook.platform.order.restapi;

import com.orderbook.platform.common.ResponseHandler;
import com.orderbook.platform.order.application.OrderService;
import com.orderbook.platform.order.application.OrderVO;
import com.orderbook.platform.order.restapi.request.RequestOrder;
import com.orderbook.platform.order.restapi.response.ResponseOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(
        path = "/v1/orders",
        produces = "application/json")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(
            path = "/create",
            consumes = "application/json")
    public ResponseEntity<Object> createOrder(@Validated @RequestBody RequestOrder input){
        OrderVO form = OrderVO
                .builder()
                .bookId(input.getBookId())
                .numBook(input.getNumBook())
                .customerName(input.getCustomerName())
                .expectedDeliveryDate(input.getExpectedDeliveryDate())
                .build();

        String result = orderService.createOrder(form);
        return ResponseHandler.generateResponse("Created", HttpStatus.CREATED, result);
    }

    @GetMapping(path = "")
    public ResponseEntity<Object> getAllOrder() {
        List<OrderVO> orderVOS = orderService.getAllOrder();
        List<ResponseOrder> result = new ArrayList<>();
        for (OrderVO orderVO: orderVOS) {
            result.add(ResponseOrder.from(orderVO));
        }

        return ResponseHandler.generateResponse("OK", HttpStatus.OK, result);
    }
}
