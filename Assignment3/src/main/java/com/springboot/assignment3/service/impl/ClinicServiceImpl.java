package com.springboot.assignment3.service.impl;

import com.springboot.assignment3.dao.ClinicRepository;
import com.springboot.assignment3.entity.Clinic;
import com.springboot.assignment3.entity.DoctorUser;
import com.springboot.assignment3.model.ClinicDTO;
import com.springboot.assignment3.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class ClinicServiceImpl implements ClinicService {
    @Autowired
    ClinicRepository clinicRepository;

    @Override
    public List<ClinicDTO> getOutstandingClinicList() {
        List<Clinic> clinicList = clinicRepository.findByClinicNumberChoose();
        List<ClinicDTO> clinicDTOList = new ArrayList<>();
        for (Clinic clinic : clinicList) {
            clinicDTOList.add(convert(clinic));
        }
        return clinicDTOList;
    }

    @Override
    public List<ClinicDTO> searchClinic(String keyword, String keyword2, String keyword3, String keyword4) {
        List<Clinic> clinicList = clinicRepository.searchClinic(keyword, keyword2, keyword3, keyword4);
        List<ClinicDTO> clinicDTOList = new ArrayList<>();
        for (Clinic clinic : clinicList) {
            ClinicDTO clinicDTO = new ClinicDTO();

            clinicDTO.setId(clinic.getId());
            clinicDTO.setName(clinic.getName());
            clinicDTO.setAddress(clinic.getAddress());
            clinicDTO.setWokingTime(clinic.getWokingTime());
            clinicDTO.setExaminationCosts(clinic.getExaminationCosts());

            Set<String> lists = new HashSet<>();
            for (DoctorUser doctorUser : clinic.getDoctorUsers()) {
                if (doctorUser != null){
                    lists.add(doctorUser.getSpecialization().getName());
                }

            }
            clinicDTO.setNamesOfSpecialties(lists);
            clinicDTOList.add(clinicDTO);
        }

        return clinicDTOList;
    }


    public ClinicDTO convert(Clinic clinic) {
        ClinicDTO clinicDTO = new ClinicDTO();
        clinicDTO.setId(clinic.getId());
        clinicDTO.setName(clinic.getName());
        clinicDTO.setAddress(clinic.getAddress());
        clinicDTO.setPhone(clinic.getPhone());
        clinicDTO.setDescription(clinic.getDescription());
        clinicDTO.setWokingTime(clinic.getWokingTime());
        clinicDTO.setExaminationCosts(clinic.getExaminationCosts());
        clinicDTO.setDoctorUsers(clinic.getDoctorUsers());
        return clinicDTO;
    }
}
