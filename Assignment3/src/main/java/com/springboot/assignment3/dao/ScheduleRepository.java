package com.springboot.assignment3.dao;

import com.springboot.assignment3.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    List<Schedule> findByDoctorUserId(int id);

    List<Schedule> findByPatientId(int id);
}