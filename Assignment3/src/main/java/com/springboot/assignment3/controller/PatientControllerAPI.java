package com.springboot.assignment3.controller;

import com.springboot.assignment3.entity.Schedule;
import com.springboot.assignment3.model.*;
import com.springboot.assignment3.service.DoctorUserService;
import com.springboot.assignment3.service.PatientService;
import com.springboot.assignment3.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientControllerAPI {
    @Autowired
    PatientService patientService;

    @Autowired
    DoctorUserService doctorUserService;

    @Autowired
    ScheduleService scheduleService;

    // hiển thị danh sách bệnh nhân
    @GetMapping("/doctor/listPatient")
    public ResponseEntity<?> getListPatient(){
        try {
            UserPrincipal currentUser = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            UserDTO userDTO = new UserDTO();
            userDTO.setId(currentUser.getId());

            DoctorUserDTO doctorUserDTO = doctorUserService.findById(userDTO.getId());

            // hiển thị ds bệnh nhân theo id đăng nhâ của bác sĩ
            List<PatientDTO> patientDTOList = patientService.getListPatient(doctorUserDTO.getId());
            return ResponseEntity.ok(patientDTOList);
        } catch (Exception ex){
            return ResponseEntity.badRequest().body(new MessageResponseDTO("Error"));
        }
    }


}
