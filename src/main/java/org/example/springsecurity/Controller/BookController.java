package org.example.springsecurity.Controller;

import org.example.springsecurity.Model.Book;
import org.example.springsecurity.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/student/{studentId}/books")
    public List<Book> getAllBooks(@PathVariable Long studentId){
      return bookService.getAllBooks(studentId);
    }

    @PostMapping("/student/{studentId}/book")
    public void addBook(@PathVariable Long studentId, @RequestBody Book book){
        bookService.addBook(studentId,book);
    }

    @PatchMapping("/book/{id}")
    public void updateBook(@PathVariable Long id,@RequestBody Book book){
        bookService.updateBook(id,book);
    }
}
