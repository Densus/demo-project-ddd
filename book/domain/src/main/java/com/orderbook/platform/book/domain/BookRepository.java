package com.orderbook.platform.book.domain;


import java.util.List;

public interface BookRepository {
    void save(BookAggregate bookAggregate);
    List<BookAggregate> getAllBook();
    List<BookAggregate> getAllBookByTitle(Title title);
    BookAggregate findById(Long id);
    void deleteById(Long id);
}
