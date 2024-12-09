package com.amdocs.librarymanagement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/books")       // Base URL

/* 
    Rest Controller class   -> it controls all calls of HTTP request over the network and process them.
    @RestController()  	    -> Annotation used for controller class.
    @RequestMapping(/)  	-> 

    Methods of REST APIs.
    GET	- 
    POST	- 
    PUT	- 
    DELETE	- 
*/



public class BookController {
    private final BookService bookService;  // create an object of another class to use methods of that class

@Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }

    
    
    @GetMapping("/{id}")
    // @PathVariable -> it means we are giving ID in URL.
    public Optional<Book> getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }
    
    
}
