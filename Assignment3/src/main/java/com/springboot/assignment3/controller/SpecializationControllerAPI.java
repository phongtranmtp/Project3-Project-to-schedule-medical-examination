package com.springboot.assignment3.controller;

import com.springboot.assignment3.entity.Specialization;
import com.springboot.assignment3.model.ExceptionDTO;
import com.springboot.assignment3.model.MessageResponseDTO;
import com.springboot.assignment3.model.SpecializationDTO;
import com.springboot.assignment3.service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SpecializationControllerAPI {

    @Autowired
    SpecializationService specializationService;


    @GetMapping("/user/specialist") // hiển thị thông tin các chuyên khoa nổi bật
    public ResponseEntity<?> getInfoSpecialist()  {
        try {
            List<SpecializationDTO> specializationDTOList = specializationService.getOutstandingSpecialist();
            if (specializationDTOList.isEmpty()){
                return ResponseEntity.ok("Specialization not found");
            }
            return ResponseEntity.ok(specializationDTOList);
        } catch (Exception ex){
            return ResponseEntity.badRequest().body(new MessageResponseDTO("Error"));
        }
    }
}
