package com.valoriz.bookmanagement.repository;

import com.valoriz.bookmanagement.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
    boolean existsByIsbn(String isbn);
}
