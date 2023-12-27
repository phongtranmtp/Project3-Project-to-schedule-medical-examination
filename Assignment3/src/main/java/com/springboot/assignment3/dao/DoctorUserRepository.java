package com.springboot.assignment3.dao;

import com.springboot.assignment3.entity.DoctorUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DoctorUserRepository extends JpaRepository<DoctorUser, Integer> {
    DoctorUser findByUserId(int id);

    @Query(value = "select d.* from specializations s\n" +
            "join doctor_users d on \n" +
            "d.specialization_id = s.id\n" +
            "where s.name like ?",nativeQuery = true)
    List<DoctorUser> searchBySpecialty(String keyword);
}