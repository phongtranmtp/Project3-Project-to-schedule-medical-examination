package com.springboot.assignment3.dao;

import com.springboot.assignment3.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    @Query(value = "select p.* from users u\n" +
            "join patients p on \n" +
            "p.patient_id = u.id\n" +
            "join schedules s on \n" +
            "s.patient_id = p.id \n" +
            "join doctor_users d on \n" +
            "s.doctor_id = d.id\n" +
            "where d.id = ?",nativeQuery = true)
    List<Patient> findByDoctorId(int id);


    Optional<Patient> findByUserId(int id);
}