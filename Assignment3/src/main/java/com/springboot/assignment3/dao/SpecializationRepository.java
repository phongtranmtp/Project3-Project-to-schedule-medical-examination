package com.springboot.assignment3.dao;

import com.springboot.assignment3.entity.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpecializationRepository extends JpaRepository<Specialization, Integer> {
    @Query(value = "select * from specializations\n" +
            "order by number_choose desc",nativeQuery = true)
    List<Specialization> findBySpecializationNumberChoose();
}