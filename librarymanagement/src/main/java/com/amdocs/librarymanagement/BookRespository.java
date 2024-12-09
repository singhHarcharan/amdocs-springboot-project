package com.amdocs.librarymanagement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// DOW class

// JPA Repository-> SPRING DATA JPA Depencency

// JPA Repository -> we can use JPA Respository to write preDefined methods for CRUD operations.
// We don't need to write SQL queries for everything now...
// Simple preDefined methods can be used.

// JpaRepository<Book, Long>    -> tells what kinds of values we are going to pass
@Repository     
public interface BookRespository extends JpaRepository<Book, Long> {
    
}


// testing main branch