package com.amdocs.librarymanagement;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service            // Service Layer is used to write logic for Business or to use preDefined functions of DOW Class
public class BookService {
    private final BookRespository bookRespository;

    @Autowired          //                           
    // constructor
    public BookService(BookRespository bookRespository) {
        this.bookRespository = bookRespository;
    }

    public List<Book> getAllBooks() {
        return bookRespository.findAll();       // SELECT Query of SQL to fetch all books from database.
    }

    public Optional<Book> getBookById(Long id) {
        // SELECT * FROM Books WHERE id=?
        return bookRespository.findById(id);       // SELECT Query of SQL to fetch book (of id) from database.
    }
}
