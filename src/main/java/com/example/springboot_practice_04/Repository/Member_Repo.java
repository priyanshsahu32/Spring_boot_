package com.example.springboot_practice_04.Repository;

import com.example.springboot_practice_04.Models.Custom_jsonFormat;
import com.example.springboot_practice_04.Models.Member;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Component
public interface Member_Repo extends JpaRepository<Member, Integer> {


    @Query(
            value = "SELECT m.name AS name, b.title AS title " +
                    "FROM members m " +
                    "INNER JOIN loans l ON m.id = l.member_id " +
                    "INNER JOIN books b ON b.id = l.book_id " +
                    "WHERE m.id = :memberId",
            nativeQuery = true
    )
    List<Custom_jsonFormat> getCustom_jsonFormat(@Param("memberId") int memberId);
}
