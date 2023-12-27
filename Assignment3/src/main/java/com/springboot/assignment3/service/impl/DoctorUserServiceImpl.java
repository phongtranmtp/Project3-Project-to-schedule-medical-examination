package com.springboot.assignment3.service.impl;

import com.springboot.assignment3.dao.DoctorUserRepository;
import com.springboot.assignment3.dao.UserRepository;
import com.springboot.assignment3.entity.DoctorUser;
import com.springboot.assignment3.entity.User;
import com.springboot.assignment3.model.DoctorUserDTO;
import com.springboot.assignment3.model.ExceptionDTO;
import com.springboot.assignment3.service.DoctorUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DoctorUserServiceImpl implements DoctorUserService {
    @Autowired
    DoctorUserRepository doctorUserRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public DoctorUser addAccountDoctor(DoctorUserDTO doctorUserDTO) {
        User user = userRepository.findById(doctorUserDTO.getUser().getId()).orElse(null);
        if (user == null) {
            throw new ExceptionDTO("User not found");
        } else if (user.getRole().getId() != 2) {
            throw new ExceptionDTO("The account is not a doctor role");
        }
        DoctorUser doctorUser = doctorUserRepository.findByUserId(doctorUserDTO.getUser().getId());
        if (doctorUser != null) {
            throw new ExceptionDTO("Account already exists");
        }
        doctorUser = new DoctorUser();
        doctorUser.setUser(user);
        doctorUser.setGeneralIntroduction(doctorUserDTO.getGeneralIntroduction());
        doctorUser.setTrainingProcess(doctorUserDTO.getTrainingProcess());
        doctorUser.setAchievementsAchieved(doctorUserDTO.getAchievementsAchieved());
        doctorUser.setSpecialtiesInCharge(doctorUserDTO.getSpecialtiesInCharge());
        doctorUserRepository.save(doctorUser);
        return doctorUser;
    }

    @Override
    public List<DoctorUserDTO> searchBySpecialty(String keyword) {
        List<DoctorUser> doctorUsers = doctorUserRepository.searchBySpecialty(keyword);
        List<DoctorUserDTO> doctorUserDTOList = new ArrayList<>();
        for (DoctorUser doctorUser : doctorUsers) {
            doctorUserDTOList.add(convert(doctorUser));
        }
        return doctorUserDTOList;
    }

    @Override
    public DoctorUserDTO findById(int id) {
        DoctorUser doctorUser = doctorUserRepository.findByUserId(id);
        DoctorUserDTO doctorUserDTO = convert(doctorUser);
        return doctorUserDTO;
    }


    private DoctorUserDTO convert(DoctorUser doctorUser) {
        DoctorUserDTO doctorUserDTO = new DoctorUserDTO();
        doctorUserDTO.setId(doctorUser.getId());
        doctorUserDTO.setName(doctorUser.getUser().getName());
        doctorUserDTO.setGeneralIntroduction(doctorUser.getGeneralIntroduction());
        doctorUserDTO.setTrainingProcess(doctorUser.getTrainingProcess());
        doctorUserDTO.setAchievementsAchieved(doctorUser.getAchievementsAchieved());
        doctorUserDTO.setSpecialtiesInCharge(doctorUser.getSpecialtiesInCharge());
        doctorUserDTO.setClinic(doctorUser.getClinic());
        doctorUserDTO.setSpecialization(doctorUser.getSpecialization());
        return doctorUserDTO;
    }
}
