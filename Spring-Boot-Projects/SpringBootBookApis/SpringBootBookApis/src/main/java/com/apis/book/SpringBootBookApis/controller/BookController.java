package com.apis.book.SpringBootBookApis.controller;

import java.util.Iterator;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apis.book.SpringBootBookApis.entities.Book;
import com.apis.book.SpringBootBookApis.services.BookService;


 


//@Controller --> if i am using @Controller then i need to use @ResponseBody for returning string data(not view page name)
@RestController
public class BookController {
    

     /*=============================================
    //@RequestMapping(value="/books", method=RequestMethod.GET)
    //OR
   @GetMapping("/books")//you can use either@RequestMapping or @GetMapping good to use @GetMapping
   //@ResponseBody//if you use @RestController then you don't need to use @ResponseBody it is automatically added by @RestController
    public String getBooks() {
        return "Books for testing";
    }
    */
    //=============================================
    //  @GetMapping("/books")
    //  public Book getBooks() {
    //     Book book=new Book();
    //     book.setId(1);
    //     book.setTitle("Book 1");
    //     book.setAuthor("Author 1");
    //     // return  book.toString(); //or change the return type of the method as Book
    //     return book;
    //  }



    //=============================================
   
    @Autowired
    private BookService bookService;
    /* 
    @GetMapping("/books")
    public Iterable<Book> getAllBooks() {
        // Optional: Logging or processing
        // Iterator<Book> itr = bookService.getAllBooks().iterator();
        // while (itr.hasNext()) {
        //     System.out.println(itr.next());
        // }
        
        // // Return the list directly
        // return bookService.getAllBooks();

        //2ND WAY   
        return bookService.getAllBooks();//YOU DON'T NEED TO CREATE OBJECT OF BookService CLASS ,IOC CONTAINER WILL HANDLE BEAN MANAGEMENT
   }
    */
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> list= bookService.getAllBooks();
        if(list.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }

    //=============================================
   /*  @GetMapping("/books/{id}")
    public Book getSingleBook(@PathVariable int id) {
        return bookService.getSingleBook(id);
    }
    */
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getSingleBook(@PathVariable int id) {
        Book book= bookService.getSingleBook(id);
        if(book==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }

    //=============================================
    /*
    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {//@RequestBody will convert json data to java object of type Book,here you can also use @Valid to validate the data
        return bookService.addBook(book);
    }
    */

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {//@RequestBody will convert json data to java object of type Book,here you can also use @Valid to validate the data
        try{
            Book b= bookService.addBook(book);
            System.out.println(b);
            return ResponseEntity.of(Optional.of(b));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        
    }
    //=============================================
    /* @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book book) {
        bookService.updateBook(id, book);
        return book;
    }
        */
        @PutMapping("/books/{id}")
        public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book book) {
            try {
            bookService.updateBook(id, book);
            return ResponseEntity.of(Optional.of(book));
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                }
            
        }

    //=============================================
   /*  @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable(value = "bookId") int id) {
        bookService.deleteBook(id);
    }
    */

    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable(value = "bookId") int id) {
        try {
        bookService.deleteBook(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
     
    
}
