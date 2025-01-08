package com.apis.book.SpringBootBookApis.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apis.book.SpringBootBookApis.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
    
    //most of the crud operation related methods are already implemented in JpaRepository interface 
    //but we want some custom queries
    //so we can create our own methods here
    public Book getBookById(int id);
}
