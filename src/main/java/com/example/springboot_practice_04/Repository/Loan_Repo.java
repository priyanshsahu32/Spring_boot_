package com.example.springboot_practice_04.Repository;

import com.example.springboot_practice_04.Models.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
@Component
public interface Loan_Repo extends JpaRepository<Loan, Integer> {
}
