package com.springboot.assignment3.model;

import com.springboot.assignment3.entity.DoctorUser;
import com.springboot.assignment3.entity.Status;
import com.springboot.assignment3.entity.User;
import jakarta.persistence.*;

import java.util.Set;

public class PatientDTO {
    private int id;

    private DoctorUser doctorUser;

    private Status status;

    private String name;

    private User user;

    private String gender;

    private String address;

    private Set<String> pathological;


    public PatientDTO() {
    }

    public PatientDTO(DoctorUser doctorUser, Status status, String name,
                      User user, String gender, String address, Set<String> pathological) {
        this.doctorUser = doctorUser;
        this.status = status;
        this.name = name;
        this.user = user;
        this.gender = gender;
        this.address = address;
        this.pathological = pathological;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DoctorUser getDoctorUser() {
        return doctorUser;
    }

    public void setDoctorUser(DoctorUser doctorUser) {
        this.doctorUser = doctorUser;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<String> getPathological() {
        return pathological;
    }

    public void setPathological(Set<String> pathological) {
        this.pathological = pathological;
    }
}
