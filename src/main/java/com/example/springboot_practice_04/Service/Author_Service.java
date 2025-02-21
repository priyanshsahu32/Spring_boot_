package com.example.springboot_practice_04.Service;


import com.example.springboot_practice_04.Models.Author;
import com.example.springboot_practice_04.Models.Book;
import com.example.springboot_practice_04.Repository.Author_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class Author_Service {
    @Autowired
    private Author_Repo author_repo;


    public Author addAuthor(Author author){
        return author_repo.save(author);
    }

    public Author getAuthor(int id){
        return author_repo.findById(id).get();
    }

    public List<Author> getallAuthor(){
        return author_repo.findAll();
    }

    public List<Book> getBook(int id){
        Author author = getAuthor(id);
        return new ArrayList<Book>(author.getBooks());
    }



}
