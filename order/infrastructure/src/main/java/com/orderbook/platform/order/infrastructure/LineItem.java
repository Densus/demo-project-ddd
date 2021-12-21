package com.orderbook.platform.order.infrastructure;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Builder
@Getter
@Setter
@Entity
@Table(name = "line_item")
public class LineItem extends BaseEntity {
    @Column(name = "line_num")
    private Integer lineNum;

    @Column(name = "num_books")
    private Integer numBooks;

    @Column(name = "book_price")
    private Integer bookPrice;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = LineItem.class)
    @JoinColumn(name="order_id", nullable=false)
    Order order;

    public LineItem() {

    }

    public LineItem(Integer lineNum, Integer numBooks, Integer bookPrice, Order order) {
        this.lineNum = lineNum;
        this.numBooks = numBooks;
        this.bookPrice = bookPrice;
        this.order = order;
    }
}
