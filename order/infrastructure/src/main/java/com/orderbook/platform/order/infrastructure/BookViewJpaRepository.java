package com.orderbook.platform.order.infrastructure;

import com.orderbook.platform.order.domain.BookView;
import com.orderbook.platform.order.domain.BookViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookViewJpaRepository implements BookViewRepository {
    private final BookViewDao bookViewDao;

    @Autowired
    public BookViewJpaRepository(BookViewDao bookViewDao) {
        this.bookViewDao = bookViewDao;
    }

    @Override
    public void save(BookView bookView) {
        this.bookViewDao.save(toDatabaseEntity(bookView));
    }

    @Override
    public BookView findByBookId(String isbn) {
        com.orderbook.platform.order.infrastructure.BookView bookView = this.bookViewDao.findBookByIsbn(isbn);

        return toDomainEntity(bookView);
    }

    private static com.orderbook.platform.order.infrastructure.BookView toDatabaseEntity(BookView bookViewEntity) {
        if(bookViewEntity == null) {
            return null;
        }

        return new com.orderbook.platform.order.infrastructure.BookView(
                bookViewEntity.getId(),
                bookViewEntity.getIsbn(),
                bookViewEntity.getBookPrice());
    }

    private static BookView toDomainEntity(com.orderbook.platform.order.infrastructure.BookView bookView) {
        if(bookView != null) {
            return new BookView(bookView.getId(), bookView.getIsbn(), bookView.getBookPrice());
        }

        return null;
    }
}
