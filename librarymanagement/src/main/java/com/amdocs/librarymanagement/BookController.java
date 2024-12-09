package com.amdocs.librarymanagement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




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

    // GET REQUEST
    @GetMapping
    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }

    // GET REQUEST      -> working
    @GetMapping("/{id}")
    // @PathVariable -> it means we are giving ID in URL.
    public Optional<Book> getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    // GET By Author
    
    // POST REQUEST     -> 
    @PostMapping("/addBook")
    public Book storeBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    // PUT request      -> working
    @PutMapping("updateBook/{id}")
    public Book updateBookById(@PathVariable Long id, @RequestBody Book bookDetails) {
        return bookService.updateBook(id, bookDetails);
    }

    // DELETE Request   -> working
    @DeleteMapping("/deleteBook/{id}")
    public void deleteBookById(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
