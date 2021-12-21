package com.orderbook.platform.book.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<Book, Long> {
    public Book findByTitle(String title);
    public Book findById(long id);
}
