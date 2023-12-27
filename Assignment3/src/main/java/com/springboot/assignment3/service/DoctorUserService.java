package com.springboot.assignment3.service;

import com.springboot.assignment3.entity.DoctorUser;
import com.springboot.assignment3.model.DoctorUserDTO;

import java.util.List;

public interface DoctorUserService {
    DoctorUser addAccountDoctor(DoctorUserDTO doctorUserDTO);

    List<DoctorUserDTO> searchBySpecialty(String keyword);

    DoctorUserDTO findById(int id);
}
