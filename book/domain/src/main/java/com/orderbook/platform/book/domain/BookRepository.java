package com.orderbook.platform.book.domain;


public interface BookRepository {
    void save(BookAggregate bookAggregate);
//    List<BookAggregate> getAllBook();
//    BookAggregate findByTitle(Title title);
//    BookAggregate findById(long id);
//    void deleteById(long id);
}
