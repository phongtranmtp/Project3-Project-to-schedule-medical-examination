package com.springboot.assignment3.controller;

import com.springboot.assignment3.entity.Schedule;
import com.springboot.assignment3.entity.User;
import com.springboot.assignment3.model.*;
import com.springboot.assignment3.service.ClinicService;
import com.springboot.assignment3.service.DoctorUserService;
import com.springboot.assignment3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserControllerAPI {
    @Autowired
    UserService userService;

    @Autowired
    DoctorUserService doctorUserService;

    @Autowired
    ClinicService clinicService;

    // huỷ khóa tài khoản bệnh nhân
    @PostMapping("/admin/lock_and_unlock_user")
    public ResponseEntity<?> lockAndUnlockUser(@RequestBody UserDTO userDTO) {
        try {
            User user = userService.lockAndUnlockUser(userDTO);
            return ResponseEntity.ok(user);
        } catch (Exception ex){
            return ResponseEntity.badRequest().body(new MessageResponseDTO("Error"));
        }
    }

    // hủy khóa tài khoản bác sĩ
    @PostMapping("/admin/lock_and_unlock_doctor")
    public ResponseEntity<?> lockAndUnlockDoctor(@RequestBody UserDTO userDTO) {
        try {
            User user = userService.lockAndUnlockUser(userDTO);
            return ResponseEntity.ok(user);
        } catch (Exception ex){
            return ResponseEntity.badRequest().body(new MessageResponseDTO("Error"));
        }
    }

    // hiê thị thông tin cá nhân
    @GetMapping("/user/personal_information")
    public ResponseEntity<?> getPersonalInformation() {
        try {
            UserPrincipal currentUser = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication()
                    .getPrincipal();

            UserDTO userDTO = new UserDTO();
            userDTO.setId(currentUser.getId());
            userDTO.setName(currentUser.getName());
            userDTO.setEmail(currentUser.getEmail());
            userDTO.setAddress(currentUser.getAddress());
            userDTO.setGender(currentUser.getGender());
            userDTO.setPhone(currentUser.getPhone());
            userDTO.setPassword(currentUser.getPassword());
            userDTO.setHistoryBreath(currentUser.getHistoryBreath());
            userDTO.setActive(currentUser.isActive());

            return ResponseEntity.ok(userDTO);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new MessageResponseDTO("Error"));
        }
    }

    // Tìm kiếm theo chuyên khoa của bác sĩ
    @GetMapping("/user/search_by_specialty")
    public ResponseEntity<?> searchBySpecialty(@RequestParam String keyword){
        try {
            List<DoctorUserDTO> doctorUserDTOList = doctorUserService.searchBySpecialty(keyword);
            if (doctorUserDTOList.isEmpty()){
                return ResponseEntity.ok("Doctor not found");
            }
            return ResponseEntity.ok(doctorUserDTOList);
        } catch (Exception ex){
            return ResponseEntity.badRequest().body(new MessageResponseDTO("Error"));
        }
    }

    // Tìm kiếm chung
    @GetMapping("/user/search/cliniclist") // tìm kiếm phòng khám
    public ResponseEntity<?> searchClinic(@RequestParam(name = "keyword",required = false) String keyword,
                                          @RequestParam(name = "keyword2",required = false) String keyword2,
                                          @RequestParam(name = "keyword3",required = false) String keyword3,
                                          @RequestParam(name = "keyword4",required = false) String keyword4) {
        try {
            List<ClinicDTO> clinicDTOList = clinicService.searchClinic(keyword,keyword2,keyword3,keyword4);
            if (clinicDTOList.isEmpty()) {
                return ResponseEntity.ok("Clinic not found");
            }
            return ResponseEntity.ok(clinicDTOList);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest().body(new MessageResponseDTO("Error"));

        }
    }
}
