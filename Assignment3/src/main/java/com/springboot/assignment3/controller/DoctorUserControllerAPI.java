package com.springboot.assignment3.controller;

import com.springboot.assignment3.entity.DoctorUser;
import com.springboot.assignment3.entity.Schedule;
import com.springboot.assignment3.model.*;
import com.springboot.assignment3.password.MailService;
import com.springboot.assignment3.service.DoctorUserService;
import com.springboot.assignment3.service.PatientService;
import com.springboot.assignment3.service.ScheduleService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
public class DoctorUserControllerAPI {
    @Autowired
    DoctorUserService doctorUserService;

    @Autowired
    ScheduleService scheduleService;

    @Autowired
    MailService mailService;


    // Thêm tài khoản bác sĩ
    @PostMapping("/admin/addAccountDoctor")
    public ResponseEntity<?> addAccountDoctor(@RequestBody DoctorUserDTO doctorUserDTO){
        try {
            DoctorUser doctorUser = doctorUserService.addAccountDoctor(doctorUserDTO);
            return ResponseEntity.ok(doctorUser);
        } catch (Exception ex){
            return ResponseEntity.badRequest().body(new MessageResponseDTO("Error"));
        }
    }

    // guiwr thông tin khám chữa bệnh qua mail
    @PostMapping(value = "/doctor/send_information")
    public String sendInformation(@RequestParam int id)
            throws MessagingException, UnsupportedEncodingException {
        try {
            Schedule schedule = scheduleService.findbyScheduleId(id);
            String subject = "Thông tin bệnh lý";
            String body = "Tên bệnh nhân: " + schedule.getPatient().getUser().getName();

            // tạo file pdf
            byte[] pdfByte = scheduleService.generatePdfFile(schedule);

            // tạo file name
            String fileName = schedule.getPatient().getUser().getName() + ".pdf";

            // send email
            mailService.sendInformationPatent(fileName,schedule.getPatient().getUser().getEmail(),subject,body,pdfByte);
            return "Gửi thành công";
        } catch (Exception ex){
            ex.printStackTrace();
            return "Gửi không thành công";
        }
    }




}
