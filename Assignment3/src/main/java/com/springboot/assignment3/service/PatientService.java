package com.springboot.assignment3.service;

import com.springboot.assignment3.entity.Patient;
import com.springboot.assignment3.model.PatientDTO;

import java.util.List;

public interface PatientService {
    List<PatientDTO> getListPatient(int id);

    Patient findPatientById(int id);
}
