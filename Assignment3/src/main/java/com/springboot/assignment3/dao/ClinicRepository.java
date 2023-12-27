package com.springboot.assignment3.dao;

import com.springboot.assignment3.entity.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClinicRepository extends JpaRepository<Clinic, Integer> {
    @Query(value = "select * from clinics\n" +
            "order by number_choose desc",nativeQuery = true)
    List<Clinic> findByClinicNumberChoose();

    @Query(value = "select c.*  from clinics c \n" +
            "join doctor_users d on \n" +
            "d.clinic_id = c.id\n" +
            "join specializations s on \n" +
            "d.specialization_id = s.id\n" +
            "where c.name like ? \n" +
            "or c.address like ? \n" +
            "or c.examination_costs like ? \n" +
            "or s.name like ? " ,nativeQuery = true)
    List<Clinic> searchClinic(String keyword,String keyword2,String keyword3,String keyword4);
}