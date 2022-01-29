package com.orderbook.platform.book.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookDao extends JpaRepository<Book, Long> {
    public List<Book> getAllBookByTitle(String title);
    public Book findBookById(Long id);
}
