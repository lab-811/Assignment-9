package org.example.controller;

import org.example.entity.Book;
import org.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;


    @GetMapping("/byStatus")
    public List<Book> getBooksByStatus(@RequestParam String status){
        return bookRepository.returnNotIssuedOrIssued(status);
    }

    @GetMapping("")
    public List<Book> getAllBooks(){
        return  bookRepository.findAll();
    }

    @PostMapping("")
    public Book createBook(@RequestBody Book book){
        return bookRepository.saveAndFlush(book);
    }

    @PutMapping("/update/{id}")
    public Book updateBook(@PathVariable Long id,
                           @RequestBody Book book){
        book.setId(id);
        return  bookRepository.saveAndFlush(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {

        bookRepository.deleteById(id);
    }

    @PatchMapping("/update/id")
    public Book updateBookStatus(@PathVariable Long id,
                                 @RequestParam String status){
        Book book = bookRepository.findById(id).get();
        book.setStatus(status);
        return bookRepository.saveAndFlush(book);

    }




}
