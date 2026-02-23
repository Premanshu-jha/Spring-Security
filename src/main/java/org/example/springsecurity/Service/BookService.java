package org.example.springsecurity.Service;

import org.example.springsecurity.Model.Book;
import org.example.springsecurity.Model.BookRepository;
import org.example.springsecurity.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService extends Common{

     @Autowired
     private BookRepository bookRepository;

     public List<Book> getAllBooks(Long studentId){
        return bookRepository.findAllByStudentId(studentId).orElseThrow(()->new RuntimeException("No books found for the given student"));
     }

     public Book getBook(Long id){
         return bookRepository.findById(id).orElseThrow(()->new RuntimeException("No books found for the given student"));
     }

     public void addBook(Long studentId,Book book){
         Student student = getStudent(studentId);
         book.setStudent(student);
         bookRepository.save(book);
     }

     public void updateBook(Long id,Book reqBody){
         Book book = getBook(id);
         if(reqBody.getBookName() != null) book.setBookName(reqBody.getBookName());
         bookRepository.save(book);
     }

}
