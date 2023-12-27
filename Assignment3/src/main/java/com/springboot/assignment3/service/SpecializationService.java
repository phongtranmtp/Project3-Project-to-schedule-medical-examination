package com.springboot.assignment3.service;

import com.springboot.assignment3.model.SpecializationDTO;

import java.util.List;

public interface SpecializationService {
    SpecializationDTO getInfoSpecialist(int id);

    List<SpecializationDTO> getOutstandingSpecialist();
}
