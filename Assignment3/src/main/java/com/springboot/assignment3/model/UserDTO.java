package com.springboot.assignment3.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.springboot.assignment3.entity.DoctorUser;
import com.springboot.assignment3.entity.Extrainfo;
import com.springboot.assignment3.entity.Patient;
import com.springboot.assignment3.entity.Role;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

public class UserDTO {
    private int id;

    private String name;

    private String email;

    private String password;

    private String address;

    private String phone;

    private String avatar;

    private String gender;

    private String description;

    private Role role;

    private boolean isActive;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

    private String checkPass;

    private Patient patient;

    private DoctorUser doctorUser;
    private String historyBreath;

    public UserDTO() {
    }

    public UserDTO(String name, String email, String password, String address,Patient patient,String historyBreath,
                   String phone, String avatar, String gender, String description,String checkPass,DoctorUser doctorUser,
                   Role role, boolean isActive, Date createdAt, Date updatedAt, Date deletedAt) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.avatar = avatar;
        this.gender = gender;
        this.description = description;
        this.role = role;
        this.historyBreath = historyBreath;
        this.isActive = isActive;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.checkPass = checkPass;
        this.patient = patient;
        this.doctorUser = doctorUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getCheckPass() {
        return checkPass;
    }

    public void setCheckPass(String checkPass) {
        this.checkPass = checkPass;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getHistoryBreath() {
        return historyBreath;
    }

    public void setHistoryBreath(String historyBreath) {
        this.historyBreath = historyBreath;
    }

    public DoctorUser getDoctorUser() {
        return doctorUser;
    }

    public void setDoctorUser(DoctorUser doctorUser) {
        this.doctorUser = doctorUser;
    }
}
