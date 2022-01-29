package com.orderbook.platform.book.infrastructure;

import com.orderbook.platform.book.domain.Author;
import com.orderbook.platform.book.domain.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AuthorJpaRepository implements AuthorRepository {
    private AuthorDao authorDao;

    @Autowired
    public AuthorJpaRepository(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Override
    public void save(Author authorEntity) {
        this.authorDao.save(toDatabaseEntity(authorEntity));
    }


    private static com.orderbook.platform.book.infrastructure.Author toDatabaseEntity(Author authorEntity) {
        com.orderbook.platform.book.infrastructure.Author author = new com.orderbook.platform.book.infrastructure.Author();
        author.setName(authorEntity.getAuthor());

        return author;
    }
}
