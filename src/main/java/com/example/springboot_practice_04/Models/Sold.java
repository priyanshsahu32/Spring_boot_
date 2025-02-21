package com.example.springboot_practice_04.Models;


import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Table(name = "sold")

public class Sold {


    @Id
    private int id;




    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;


    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;






    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }





















}
