package com.orderbook.platform.book.application;

import java.util.List;

public interface BookService {
    public String createBook(CreateBookVO bookVO);
    public List<BookDto> getAllBook();
    public BookDto getBookDetailById(Long id);
    public BookDto updateBookById(CreateBookVO bookVO, Long id);
    public List<BookDto> getAllBookByTitle(String title);
    public void deleteBookById(Long id);
}
