package com.springboot.assignment3.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.springboot.assignment3.entity.DoctorUser;
import jakarta.persistence.Column;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class ClinicDTO {
    private int id;

    private String name;

    private String address;

    private String phone;

    private String introductionHTML;

    private String introductionMarkdown;

    private String description;

    private String image;

    private List<DoctorUser> doctorUsers;

    private int numberChoose;
    private String wokingTime;
    private int examinationCosts;

    private Set<String> namesOfSpecialties;


    private Date createdAt;

    public ClinicDTO() {
    }

    public ClinicDTO(String name, String address, String phone,String wokingTime,int examinationCosts,
                     String introductionHTML, String introductionMarkdown,
                     String description, String image, int numberChoose, Date createdAt) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.examinationCosts = examinationCosts;
        this.wokingTime = wokingTime;
        this.introductionHTML = introductionHTML;
        this.introductionMarkdown = introductionMarkdown;
        this.description = description;
        this.image = image;
        this.numberChoose = numberChoose;
        this.createdAt = createdAt;
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

    public String getIntroductionHTML() {
        return introductionHTML;
    }

    public void setIntroductionHTML(String introductionHTML) {
        this.introductionHTML = introductionHTML;
    }

    public String getIntroductionMarkdown() {
        return introductionMarkdown;
    }

    public void setIntroductionMarkdown(String introductionMarkdown) {
        this.introductionMarkdown = introductionMarkdown;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getNumberChoose() {
        return numberChoose;
    }

    public void setNumberChoose(int numberChoose) {
        this.numberChoose = numberChoose;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getWokingTime() {
        return wokingTime;
    }

    public void setWokingTime(String wokingTime) {
        this.wokingTime = wokingTime;
    }

    public int getExaminationCosts() {
        return examinationCosts;
    }

    public void setExaminationCosts(int examinationCosts) {
        this.examinationCosts = examinationCosts;
    }

    public Set<String> getNamesOfSpecialties() {
        return namesOfSpecialties;
    }

    public void setNamesOfSpecialties(Set<String> namesOfSpecialties) {
        this.namesOfSpecialties = namesOfSpecialties;
    }

    public List<DoctorUser> getDoctorUsers() {
        return doctorUsers;
    }

    public void setDoctorUsers(List<DoctorUser> doctorUsers) {
        this.doctorUsers = doctorUsers;
    }
}
