package com.amdocs.librarymanagement;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// MVC Architecture
// https://www.javatpoint.com/mvc-architecture-in-java
// 

@Service            // Service Layer is used to write logic for Business or to use preDefined functions of DOW Class
public class BookService {
    private final BookRepository bookRepository;

    @Autowired          //                           
    // constructor
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();           // SELECT Query of SQL to fetch all books from database.
    }

    public Optional<Book> getBookById(Long id) {
        // SELECT * FROM Books WHERE id=?
        return bookRepository.findById(id);       // SELECT Query of SQL to fetch book (of id) from database.
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);        // INSERT QUERY  
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);             // DELETE Query
    }

    public Book updateBook(Long id, Book bookDetails) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));

        // Update Values using Getter and Setter
        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setQuantity(bookDetails.getQuantity());

        return bookRepository.save(book);          // Save changes in database permanently
    }
}
