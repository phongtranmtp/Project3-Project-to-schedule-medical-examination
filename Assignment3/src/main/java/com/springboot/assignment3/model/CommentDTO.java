package com.springboot.assignment3.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.springboot.assignment3.entity.DoctorUser;
import com.springboot.assignment3.entity.Patient;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

public class CommentDTO {

    private int id;

    private DoctorUser doctorUser;

    private String name;

    private String timeBooking;

    private String dateBooking;

    private String email;

    private String phone;

    private String content;

    private String examinationPrice;

    private Patient patient;

    private boolean status;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

    public CommentDTO() {
    }

    public CommentDTO(DoctorUser doctorUser, String name, String timeBooking,String examinationPrice,
                      String dateBooking, String email, String phone, String content,
                      boolean status, Date createdAt, Date updatedAt, Date deletedAt) {
        this.doctorUser = doctorUser;
        this.name = name;
        this.timeBooking = timeBooking;
        this.dateBooking = dateBooking;
        this.email = email;
        this.phone = phone;
        this.content = content;
        this.examinationPrice = examinationPrice;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimeBooking() {
        return timeBooking;
    }

    public void setTimeBooking(String timeBooking) {
        this.timeBooking = timeBooking;
    }

    public String getDateBooking() {
        return dateBooking;
    }

    public void setDateBooking(String dateBooking) {
        this.dateBooking = dateBooking;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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

    public String getExaminationPrice() {
        return examinationPrice;
    }

    public void setExaminationPrice(String examinationPrice) {
        this.examinationPrice = examinationPrice;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

}
