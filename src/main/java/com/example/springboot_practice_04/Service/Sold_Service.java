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


    public Sold addTxt(int sold_id,int book_id,int member_id){
        Book book = book_repo.findById(book_id).get();
        Member member = member_repo.findById(member_id).get();

        Sold sold = new Sold();
        sold.setId(sold_id);
        sold.setBook(book);
        sold.setMember(member);


        return repo.save(sold);

    }
}
