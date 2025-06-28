package com.valoriz.bookmanagement.controller;

import com.valoriz.bookmanagement.model.Book;
import com.valoriz.bookmanagement.service.BookService;
import com.valoriz.bookmanagement.service.GoogleBooksService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;


    @Autowired
    private GoogleBooksService googleBooksService;

    @PostMapping
    public Book addBook(@Valid @RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable String id) {
        return bookService.getBookById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable String id) {
        bookService.deleteBook(id);
    }

    @GetMapping("/external/google-books/{isbn}")
    public Map<String, Object> getBookDetailsFromGoogle(@PathVariable String isbn) {
        return googleBooksService.fetchBookDetailsByIsbn(isbn);
    }
}
