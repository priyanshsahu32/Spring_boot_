package com.example.springboot_practice_04.Service;

import com.example.springboot_practice_04.Models.Author;
import com.example.springboot_practice_04.Models.Book;
import com.example.springboot_practice_04.Repository.Author_Repo;
import com.example.springboot_practice_04.Repository.Book_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
@Component
public class Book_service {
    @Autowired
    private Book_Repo bookRepo;
    @Autowired
    private Author_Repo author_repo;



    public Book createBook(Book book) {
        return bookRepo.save(book);
    }

    public Book findBookById(int id) {
         return bookRepo.findById(id).get();
    }

    public List<Book> findAllBooks() {
        return bookRepo.findAll();
    }

    public Book updateBook(Book book){
        return bookRepo.save(book);
    }

    public void deleteBook(int id) {
        bookRepo.deleteById(id);
        return;
    }


    public void addAuthorToBook(int book_id,int author_id){
        Author author = author_repo.findById(author_id)
                .orElseThrow(() -> new RuntimeException("Author not found"));
        Book book = bookRepo.findById(book_id).get();
        book.getAuthors().add(author);
        bookRepo.save(book);
        return;



    }


}
