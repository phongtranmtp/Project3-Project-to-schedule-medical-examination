package com.springboot.assignment3.service;

import com.springboot.assignment3.model.ClinicDTO;

import java.util.List;

public interface ClinicService {
    List<ClinicDTO> getOutstandingClinicList();

    List<ClinicDTO> searchClinic(String keyword,String keyword2,String keyword3,String keyword4);
}
