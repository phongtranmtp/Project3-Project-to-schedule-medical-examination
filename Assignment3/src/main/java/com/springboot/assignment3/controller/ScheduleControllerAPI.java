package com.springboot.assignment3.controller;

import com.springboot.assignment3.entity.Schedule;
import com.springboot.assignment3.model.MessageResponseDTO;
import com.springboot.assignment3.model.ScheduleDTO;
import com.springboot.assignment3.model.UserPrincipal;
import com.springboot.assignment3.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScheduleControllerAPI {
    @Autowired
    ScheduleService scheduleService;

    // đặt lịch khám
    @PostMapping("/user/booking")
    public ResponseEntity<?> addMakeAnAppointment(@RequestBody ScheduleDTO scheduleDTO){
        try {

             Schedule schedule = scheduleService.addMakeAnAppointment(scheduleDTO);
            return ResponseEntity.ok(schedule);
        } catch (Exception ex){
            return ResponseEntity.badRequest().body(new MessageResponseDTO("Error"));
        }
    }

    // Xác nhận lịch khám
    @PostMapping("/doctor/confirm/{id}")
    public ResponseEntity<?> confirm(@PathVariable int id){
        try {
            Schedule schedule = scheduleService.confirm(id);
            return ResponseEntity.ok(schedule);
        } catch (Exception ex){
            return ResponseEntity.badRequest().body(new MessageResponseDTO("Error"));
        }
    }

    // Từ chối lịch khám
    @PostMapping("/doctor/un_confirm/{id}")
    public ResponseEntity<?> unConfirm(@PathVariable int id,
                                       @RequestParam(value = "description" , required = false) String description){
        try {
            Schedule schedule = scheduleService.unConfirm(id,description);
            return ResponseEntity.ok(schedule);
        } catch (Exception ex){
            return ResponseEntity.badRequest().body(new MessageResponseDTO("Error"));
        }
    }

    // Xem thông tin chi tiết lịch khám của từng bác sĩ
    @GetMapping("/doctor/detail_schedule_of_doctor/{id}")
    public ResponseEntity<?> detailScheduleOfDoctor(@PathVariable int id){
        try {
            List<Schedule> schedule = scheduleService.detailScheduleOfDoctor(id);
            return ResponseEntity.ok(schedule);
        } catch (Exception ex){
            return ResponseEntity.badRequest().body(new MessageResponseDTO("Error"));
        }
    }

    // Xem thông tin chi tiết lịch khám của từng bệnh nhân
    @GetMapping("/user/detail_schedule_of_user/{id}")
    public ResponseEntity<?> detailScheduleOfUser(@PathVariable int id){
        try {
            List<Schedule> schedule = scheduleService.detailScheduleOfUser(id);
            return ResponseEntity.ok(schedule);
        } catch (Exception ex){
            return ResponseEntity.badRequest().body(new MessageResponseDTO("Error"));
        }
    }

}
