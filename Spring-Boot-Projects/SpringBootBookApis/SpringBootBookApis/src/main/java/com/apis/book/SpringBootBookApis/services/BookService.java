package com.apis.book.SpringBootBookApis.services;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.apis.book.SpringBootBookApis.entities.Book;

@Service
public class BookService {
    private static List<Book> books=new ArrayList<>();
    static{
        books.add(new Book(1,"Book 1","Author 1"));
        books.add(new Book(2,"Book 2","Author 2"));
        books.add(new Book(3,"Book 3","Author 3"));
         
    }

    //to get all books
    public List<Book> getAllBooks(){
        return books;
    }

    //to get single book by id
    public Book getSingleBook(int id){
        // return books.stream().filter(book->book.getId()==id).findFirst().get();//most used from java8
        for(Book book:books){
            if(book.getId()==id){
                return book;
            }
        }
        return null;//if not found
    }

    public Book addBook(Book book) {
        books.add(book);
        return book;//the book that came as parameter will be returned
    }

    public void updateBook(int id, Book book) {
       books = books.stream().map(b->{
            if(b.getId()==id){
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
                 
            }
            return b;
            
        }).collect(Collectors.toList());
                 
        
    }

    public void deleteBook(int id) {
       for(Book book:books){
           if(book.getId()==id){
               books.remove(book);
           }
       }
       //============================================
       //2nd way
       // books.removeIf(book->book.getId()==id);
       //============================================
       //3rd way using stream
       // Method to delete book by id
     
        // books = books.stream()
        //              .filter(book -> book.getId() != id)
        //              .collect(Collectors.toList());

         //================================            
    // public List<Book> getAllBooks() {
    //     return books;
    // }

    //============================================

    }

}
