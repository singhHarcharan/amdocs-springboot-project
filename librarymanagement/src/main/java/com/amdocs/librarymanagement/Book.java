package com.amdocs.librarymanagement;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// Annotations type -> 1.) Class level 2.) Method level

// Entity Class -> 
// where all variables are encapsulated by making them private. Ony setter and getter can access them.

// when we run entity class, it will make table with name of className in database having variables as column names. 
@Entity
public class Book {
@Id                     // This is used to state that we are using 'id' variable as primary key
@GeneratedValue(strategy = GenerationType.IDENTITY)     // this makes 'id' key auto incremented. 
    private Long id;
    private String title;
    private String author;
    private int quantity;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
