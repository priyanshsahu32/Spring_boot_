package com.example.springboot_practice_04.Controller;


import com.example.springboot_practice_04.Models.Loan;
import com.example.springboot_practice_04.Service.Loan_Service;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loan")
public class Loan_Controller {
    @Autowired
    Loan_Service loan_service;

    @PostMapping("/issueloan/{bookid}/{memberid}")
    public ResponseEntity<Loan> issueLoan(@PathVariable int bookid, @PathVariable int memberid) {
        return ResponseEntity.ok(loan_service.issue_loan(bookid,memberid));
    }

    @GetMapping("/getloan/{id}")
    public ResponseEntity<Loan> getLoan(@PathVariable int id){
        return ResponseEntity.ok(loan_service.get_loan(id));
    }


}
