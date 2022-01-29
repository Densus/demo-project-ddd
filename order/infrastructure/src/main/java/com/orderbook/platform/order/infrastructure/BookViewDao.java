package com.orderbook.platform.order.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookViewDao extends JpaRepository<BookView, Long> {
    public BookView findBookByIsbn(String isbn);
}
