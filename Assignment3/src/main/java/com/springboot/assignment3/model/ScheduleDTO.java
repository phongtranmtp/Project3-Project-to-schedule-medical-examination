package com.springboot.assignment3.model;

import com.springboot.assignment3.entity.Clinic;
import com.springboot.assignment3.entity.DoctorUser;
import com.springboot.assignment3.entity.Patient;
import com.springboot.assignment3.entity.User;
import jakarta.persistence.*;

public class ScheduleDTO {
    private int id;

    private DoctorUser doctorUser;

    private String date;

    private String time;

    private int status;

    private int patient;

    private String description;
    private Clinic clinic;

    private String maxBooking;

    private String sumBooking;

    private String examinationPrice;

    private String personalInformation;

    private String pathological;

    public ScheduleDTO() {
    }

    public ScheduleDTO(DoctorUser doctorUser, String date, String time,
                       Patient patient, Clinic clinic, String maxBooking, String sumBooking,
                       String examinationPrice, String personalInformation, String pathological) {
        this.doctorUser = doctorUser;
        this.date = date;
        this.time = time;
        this.clinic = clinic;
        this.maxBooking = maxBooking;
        this.sumBooking = sumBooking;
        this.examinationPrice = examinationPrice;
        this.personalInformation = personalInformation;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public String getMaxBooking() {
        return maxBooking;
    }

    public void setMaxBooking(String maxBooking) {
        this.maxBooking = maxBooking;
    }

    public String getSumBooking() {
        return sumBooking;
    }

    public void setSumBooking(String sumBooking) {
        this.sumBooking = sumBooking;
    }

    public String getExaminationPrice() {
        return examinationPrice;
    }

    public void setExaminationPrice(String examinationPrice) {
        this.examinationPrice = examinationPrice;
    }

    public String getPersonalInformation() {
        return personalInformation;
    }

    public void setPersonalInformation(String personalInformation) {
        this.personalInformation = personalInformation;
    }

    public String getPathological() {
        return pathological;
    }

    public void setPathological(String pathological) {
        this.pathological = pathological;
    }

    public int getPatient() {
        return patient;
    }

    public void setPatient(int patient) {
        this.patient = patient;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
