package com.example.springboot_practice_04.Service;


import com.example.springboot_practice_04.Models.Book;
import com.example.springboot_practice_04.Models.Member;
import com.example.springboot_practice_04.Models.Sold;
import com.example.springboot_practice_04.Repository.Book_Repo;
import com.example.springboot_practice_04.Repository.Member_Repo;
import com.example.springboot_practice_04.Repository.Sold_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Component
public class Sold_Service {


    @Autowired
    Sold_Repo repo;

    @Autowired
    Book_Repo book_repo;

    @Autowired
    Member_Repo member_repo;


    public List<Sold> getAllTxt(){
        return repo.findAll();
    }


    public Sold addTxt(int sold_id, int book_id, int member_id) {
        // Check if the book is already allotted
        Optional<Sold> existingSold = repo.findByBookId(book_id);
        if (existingSold.isPresent()) {
            throw new RuntimeException("Book is already allotted");
        }

        // Fetch book and member details
        Book book = book_repo.findById(book_id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        Member member = member_repo.findById(member_id)
                .orElseThrow(() -> new RuntimeException("Member not found"));

        // Create and save new Sold entry
        Sold sold = new Sold();
        sold.setId(sold_id);
        sold.setBook(book);
        sold.setMember(member);

        return repo.save(sold);
    }

}
