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
    private final BookRespository bookRespository;

    @Autowired          //                           
    // constructor
    public BookService(BookRespository bookRespository) {
        this.bookRespository = bookRespository;
    }

    public List<Book> getAllBooks() {
        return bookRespository.findAll();           // SELECT Query of SQL to fetch all books from database.
    }

    public Optional<Book> getBookById(Long id) {
        // SELECT * FROM Books WHERE id=?
        return bookRespository.findById(id);       // SELECT Query of SQL to fetch book (of id) from database.
    }

    public Book getBookById(Book book) {
        return bookRespository.save(book);          // INSERT Query
    }

    public void deleteBook(Long id) {
        bookRespository.deleteById(id);             // DELETE Query
    }

    public Book updateBook(Long id, Book bookDetails) {
        Book book = bookRespository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));

        // Update Values using Getter and Setter
        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setQuantity(bookDetails.getQuantity());

        return bookRespository.save(book);          // Save changes in database permanently
    }
}
