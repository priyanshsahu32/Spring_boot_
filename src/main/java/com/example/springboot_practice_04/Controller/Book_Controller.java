package com.example.springboot_practice_04.Controller;


import com.example.springboot_practice_04.Models.Book;
import com.example.springboot_practice_04.Service.Book_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class Book_Controller {
    @Autowired
    private Book_service book_service;
    @Autowired
    private Book book;

    @PostMapping("/createbook")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        return ResponseEntity.ok(book_service.createBook(book));
    }

    @GetMapping("/getbook/{id}")
    public ResponseEntity<Book> getBook(@PathVariable int id) {
        return ResponseEntity.ok(book_service.findBookById(id));
    }

    @GetMapping("/getbooks")
    public ResponseEntity<List<Book>> getBooks() {
        return ResponseEntity.ok(book_service.findAllBooks());

    }

    @PutMapping("/updatebook")
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
        return ResponseEntity.ok(book_service.updateBook(book));
    }

    @DeleteMapping("/deletebook/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id){

        book_service.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{book_id}/autor/{author_id}")
    public ResponseEntity<Void> addAuthor(@PathVariable int book_id, @PathVariable int author_id){
        book_service.addAuthorToBook(book_id,author_id);
        return ResponseEntity.noContent().build();

    }



}
