package com.orderbook.platform.book.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorDao extends JpaRepository<Author, Long> {
    Optional<Author> findByName(String name);
}
