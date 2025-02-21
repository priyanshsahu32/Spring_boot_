package com.example.springboot_practice_04.Service;


import com.example.springboot_practice_04.Models.Custom_jsonFormat;
import com.example.springboot_practice_04.Models.Loan;
import com.example.springboot_practice_04.Models.Member;
import com.example.springboot_practice_04.Repository.Loan_Repo;
import com.example.springboot_practice_04.Repository.Member_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class Member_service {
    @Autowired
    Member_Repo repo;

    @Autowired
    Loan_Repo loan_repo;

    public Member addMember(Member member){
        return repo.save(member);
    }

    public Member getMember(int member_id){
        return repo.findById(member_id).get();
    }


    public List<Loan> getloans(int memberid) {

        Member m = repo.findById(memberid).get();
        return m.getLoans();


    }

    public List<Custom_jsonFormat> getCustomJson(int id) {

        return repo.getCustom_jsonFormat(id);
    }
}
