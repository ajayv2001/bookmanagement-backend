package com.valoriz.bookmanagement.service;

import com.valoriz.bookmanagement.model.Book;
import com.valoriz.bookmanagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    public Book addBook(Book book) {
        long seqNumber = sequenceGeneratorService.generateSequence("books_sequence");
        String generatedId = "B-" + String.format("%03d", seqNumber);
        book.setId(generatedId);
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(String id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void deleteBook(String id) {
        bookRepository.deleteById(id);
    }
}
