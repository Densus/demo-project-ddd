package com.orderbook.platform.order.domain;

public interface BookViewRepository {
    void save(BookView bookView);

    BookView findByBookId(String isbn);
}
