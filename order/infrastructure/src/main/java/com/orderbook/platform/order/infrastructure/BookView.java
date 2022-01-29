package com.orderbook.platform.order.infrastructure;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Builder
@Getter
@Setter
@Entity
@Table(name = "book_view")
public class BookView {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "book_price")
    private BigDecimal bookPrice;

    public BookView() {
    }

    public BookView(Long id, String isbn, BigDecimal bookPrice) {
        this.id = id;
        this.isbn = isbn;
        this.bookPrice = bookPrice;
    }
}
