package com.example.springboot_practice_04.Controller;


import com.example.springboot_practice_04.Models.Sold;
import com.example.springboot_practice_04.Service.Sold_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sold")
public class Sold_Controller {

    @Autowired
    Sold_Service soldService;

    @GetMapping("/getAllTxr")
    public ResponseEntity<List<Sold>> getAllTxr(){
        return ResponseEntity.ok(soldService.getAllTxt());
    }


    @PostMapping("/addTxt/{sold_id}/{book_id}/{member_id}")
    public ResponseEntity<Sold> AddTxt(@PathVariable int sold_id,@PathVariable int book_id,@PathVariable int member_id){
        return ResponseEntity.ok(soldService.addTxt(sold_id,book_id,member_id));
    }

}
