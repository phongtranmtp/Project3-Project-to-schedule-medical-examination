package com.springboot.assignment3.controller;

import com.springboot.assignment3.model.ClinicDTO;
import com.springboot.assignment3.model.MessageResponseDTO;
import com.springboot.assignment3.model.SpecializationDTO;
import com.springboot.assignment3.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClinicControllerAPI {
    @Autowired
    ClinicService clinicService;

    @GetMapping("/user/cliniclist") // hiển thị thông tin các chuyên khoa nổi bật
    public ResponseEntity<?> getInfoClinic() {
        try {
            List<ClinicDTO> clinicDTOList = clinicService.getOutstandingClinicList();
            if (clinicDTOList.isEmpty()) {
                return ResponseEntity.ok("Clinic not found");
            }
            return ResponseEntity.ok(clinicDTOList);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new MessageResponseDTO("Error"));
        }
    }


}
