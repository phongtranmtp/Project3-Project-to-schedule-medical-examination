package com.springboot.assignment3.service.impl;

import com.springboot.assignment3.dao.PatientRepository;
import com.springboot.assignment3.entity.Patient;
import com.springboot.assignment3.entity.Schedule;
import com.springboot.assignment3.model.PatientDTO;
import com.springboot.assignment3.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {
    @Autowired
    PatientRepository patientRepository;
    @Override
    public List<PatientDTO> getListPatient(int id) {
        List<Patient> patients = patientRepository.findByDoctorId(id);
        List<PatientDTO> patientDTOList = new ArrayList<>();
        for (Patient patient : patients) {

            PatientDTO patientDTO = new PatientDTO();
            patientDTO.setId(patient.getId());
            patientDTO.setGender(patient.getUser().getGender());
            patientDTO.setAddress(patient.getUser().getAddress());
            patientDTO.setName(patient.getUser().getName());

            Set<String> lists = new HashSet<>();
            for (Schedule schedule : patient.getSchedule()) {
                if (schedule != null){
                    lists.add(schedule.getPathological());
                }
            }
            patientDTO.setPathological(lists);
            patientDTOList.add(patientDTO);
        }
        return patientDTOList;
    }

    @Override
    public Patient findPatientById(int id) {
        Patient patient = patientRepository.findById(id).orElse(null);
        return patient;
    }

    private PatientDTO convert(Patient patient) {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setId(patient.getId());
        patientDTO.setGender(patient.getUser().getGender());
        patientDTO.setAddress(patient.getUser().getAddress());
        patientDTO.setName(patient.getUser().getName());
        return patientDTO;
    }
}
