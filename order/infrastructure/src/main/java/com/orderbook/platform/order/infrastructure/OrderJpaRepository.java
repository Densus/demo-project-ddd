package com.orderbook.platform.order.infrastructure;

import com.orderbook.platform.book.infrastructure.Book;
import com.orderbook.platform.book.infrastructure.BookDao;
import com.orderbook.platform.order.domain.OrderAggregate;
import com.orderbook.platform.order.domain.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class OrderJpaRepository implements OrderRepository {
    private final OrderDao orderDao;
    private final BookDao bookDao;

    @Autowired
    public OrderJpaRepository(OrderDao orderDao, BookDao bookDao) {
        this.orderDao = orderDao;
        this.bookDao = bookDao;
    }

    @Override
    public void createOrder(OrderAggregate orderAggregate) {
        Book book = this.bookDao.findBookById(orderAggregate.getBookId());
        Order order = toDatabaseEntity(orderAggregate, book);
        this.orderDao.save(order);
    }

    @Override
    public List<OrderAggregate> getAllOrder() {
        List<Order> orders = this.orderDao.findAll();

        return toListDomainEntity(orders);
    }

    private static Order toDatabaseEntity(OrderAggregate orderEntity, Book book) {
        Integer orgPrice = book.getOrgPrice().intValueExact();
        Integer total_price = (orgPrice * orderEntity.getNumBook());

        Long id = orderEntity.getId();
        Long bookId = orderEntity.getBookId();
        BigDecimal bookPrice = new BigDecimal(total_price);
        String customerName = orderEntity.getCustomerName();
        Date expectedDeliveryDate = orderEntity.getExpectedDeliveryDate();
        Integer numBooks = orderEntity.getNumBook();

        return new Order(id, bookId, bookPrice, expectedDeliveryDate, customerName, numBooks);
    }

    private static List<OrderAggregate> toListDomainEntity(List<Order> orders) {
        List<OrderAggregate> orderAggregates = new ArrayList<>();
        if(orders != null) {
            for (Order order : orders) {
                orderAggregates.add(toDomainEntity(order));
            }
            return orderAggregates;
        }

        return null;
    }

    private static OrderAggregate toDomainEntity(Order order) {
        if(order != null) {
            return new OrderAggregate(order.getId(), order.getBookId(), order.getCustomerName(),
                    order.getExpectedDeliveryDate(), order.getNumBooks(), order.getBookPrice());
        }

        return null;
    }
}
