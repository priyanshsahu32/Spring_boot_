package com.example.springboot_practice_04.Repository;


import com.example.springboot_practice_04.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface Author_Repo extends JpaRepository<Author, Integer> {
}
