package com.example.springboot_practice_04.Controller;


import com.example.springboot_practice_04.Models.Custom_jsonFormat;
import com.example.springboot_practice_04.Models.Loan;
import com.example.springboot_practice_04.Models.Member;
import com.example.springboot_practice_04.Service.Member_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
public class Member_Controller {

    @Autowired
    Member_service member_service;

    @PostMapping("/addmember")
    public ResponseEntity<Member> addMember(@RequestBody Member member) {
        return ResponseEntity.ok(member_service.addMember(member));
    }
    @GetMapping("/getmemberbyid{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable int id) {
        return ResponseEntity.ok(member_service.getMember(id));
    }


    @GetMapping("/getloandetails/{memberid}")
    public ResponseEntity<List<Loan>> getloanDetails(@PathVariable int memberid) {
        return ResponseEntity.ok(member_service.getloans(memberid));
    }


    @GetMapping("/getCustomJson/{id}")
    public ResponseEntity<List<Custom_jsonFormat>> getCustomJson(@PathVariable int id) {
        return ResponseEntity.ok(member_service.getCustomJson(id));
    }





}
