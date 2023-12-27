package com.springboot.assignment3.service.impl;

import com.springboot.assignment3.dao.SpecializationRepository;
import com.springboot.assignment3.entity.Specialization;
import com.springboot.assignment3.model.SpecializationDTO;
import com.springboot.assignment3.service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SpecializationServiceImpl implements SpecializationService {

    @Autowired
    SpecializationRepository specializationRepository;
    @Override
    public SpecializationDTO getInfoSpecialist(int id) {
        Specialization specialization = specializationRepository.findById(id).orElse(null);
        SpecializationDTO specializationDTO = convert(specialization);
        return specializationDTO;
    }

    @Override
    public List<SpecializationDTO> getOutstandingSpecialist() {
        List<Specialization> specializationList = specializationRepository.findBySpecializationNumberChoose();
        List<SpecializationDTO> specializationDTOList = new ArrayList<>();
        for (Specialization specialization : specializationList) {
            specializationDTOList.add(convert(specialization));
        }
        return specializationDTOList;
    }

    public SpecializationDTO convert(Specialization specialization){
        SpecializationDTO specializationDTO = new SpecializationDTO();
        specializationDTO.setId(specialization.getId());
        specializationDTO.setName(specialization.getName());
        specializationDTO.setDescription(specialization.getDescription());
        specializationDTO.setImage(specialization.getImage());
        specializationDTO.setCreatedAt(specialization.getCreatedAt());
        specializationDTO.setUpdatedAt(specialization.getUpdatedAt());
        specializationDTO.setDeletedAt(specialization.getDeletedAt());
        return specializationDTO;
    }
}
