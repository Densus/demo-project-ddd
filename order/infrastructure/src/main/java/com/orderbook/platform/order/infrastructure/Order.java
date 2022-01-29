package com.orderbook.platform.order.infrastructure;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Builder
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "book_price")
    private BigDecimal bookPrice;

    @Column(name = "expected_delivery_date")
    private Date expectedDeliveryDate;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "num_books")
    private Integer numBooks;

    public Order() {

    }

    public Order(Long id, Long bookId, BigDecimal bookPrice, Date expectedDeliveryDate, String customerName, Integer numBooks) {
        this.id = id;
        this.bookId = bookId;
        this.bookPrice = bookPrice;
        this.expectedDeliveryDate = expectedDeliveryDate;
        this.customerName = customerName;
        this.numBooks = numBooks;
    }

    //    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "order_id")
//    List<LineItem> lineItems;
}
