package com.orderbook.platform.order.infrastructure;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Builder
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order extends BaseEntity{
    @Column(name = "date_ordered_utc")
    private Date DateOrderedUtc;

    @Column(name = "expected_delivery_date")
    private Date expectedDeliveryDate;

    @Column(name = "customer_name")
    private String customerName;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    List<LineItem> lineItems;

    public Order() {

    }

    public Order(Date dateOrderedUtc, Date expectedDeliveryDate, String customerName, List<LineItem> lineItems) {
        DateOrderedUtc = dateOrderedUtc;
        this.expectedDeliveryDate = expectedDeliveryDate;
        this.customerName = customerName;
        this.lineItems = lineItems;
    }
}
