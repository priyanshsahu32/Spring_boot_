package com.example.springboot_practice_04.Controller;


import com.example.springboot_practice_04.Models.Author;
import com.example.springboot_practice_04.Models.Book;
import com.example.springboot_practice_04.Service.Author_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class Author_Controller {
    @Autowired
    private Author_Service author_service;

    @PostMapping("/addAuthor")
    public ResponseEntity<Author> addAuthor(@RequestBody Author author) {
        return ResponseEntity.ok(author_service.addAuthor(author));
    }

    @GetMapping("/getAuthor/{id}")
    public ResponseEntity<Author> getAuthor(@PathVariable int id) {
        return ResponseEntity.ok(author_service.getAuthor(id));
    }

    @GetMapping("/getallAuthors")
    public ResponseEntity<List<Author>> getAllAuthors() {
        return ResponseEntity.ok(author_service.getallAuthor());
    }

    @GetMapping("/getBooks/{id}")
    public ResponseEntity<List<Book>> getBook(@PathVariable int id) {
        return ResponseEntity.ok(author_service.getBook(id));
    }
}
