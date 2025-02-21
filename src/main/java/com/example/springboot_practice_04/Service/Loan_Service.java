package com.example.springboot_practice_04.Service;


import com.example.springboot_practice_04.Models.Book;
import com.example.springboot_practice_04.Models.Loan;
import com.example.springboot_practice_04.Models.Member;
import com.example.springboot_practice_04.Repository.Book_Repo;
import com.example.springboot_practice_04.Repository.Loan_Repo;
import com.example.springboot_practice_04.Repository.Member_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class Loan_Service {
    @Autowired
    Loan_Repo repo;
    @Autowired
    Book_Repo bookRepo;
    @Autowired
    Member_Repo memberRepo;


    public Loan issue_loan(int bookid,int memberid){

        Book book;
        Member member;
        Loan loan = new Loan();
        book = bookRepo.findById(bookid).get();
        member = memberRepo.findById(memberid).get();

        loan.setBook(book);
        loan.setMember(member);
        return repo.save(loan);
    }

    public Loan get_loan(int id){
        return repo.findById(id).get();
    }

}
