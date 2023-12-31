package com.springboot.assignment3.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Table(name = "schedules") // lichj trinhf
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "doctorId")
    @JsonIgnore
    private DoctorUser doctorUser;

    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;

    @Column(name = "maxBooking")
    private String maxBooking;

    @Column(name = "sumBooking")
    private String sumBooking;


    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "patientId")
    @JsonIgnore
    private Patient patient;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "clinicId")
    private Clinic clinic;

    private String examinationPrice;

    private int status;

    private String description;

    private String pathological;

    @Column(name = "createdAt")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @CreatedDate
    private Date createdAt;

    @Column(name = "updatedAt")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @CreatedDate
    private Date updatedAt;

    @Column(name = "deletedAt")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @CreatedDate
    private Date deletedAt;

    public Schedule() {
    }

    public Schedule(DoctorUser doctorUser, String date, String time, String maxBooking,
                    String sumBooking, Patient patient, Clinic clinic, String examinationPrice,
                    String personalInformation, String pathological, Date createdAt,
                    Date updatedAt, Date deletedAt) {
        this.doctorUser = doctorUser;
        this.date = date;
        this.time = time;
        this.maxBooking = maxBooking;
        this.sumBooking = sumBooking;
        this.patient = patient;
        this.clinic = clinic;
        this.examinationPrice = examinationPrice;
        this.pathological = pathological;
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

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public String getExaminationPrice() {
        return examinationPrice;
    }

    public void setExaminationPrice(String examinationPrice) {
        this.examinationPrice = examinationPrice;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPathological() {
        return pathological;
    }

    public void setPathological(String pathological) {
        this.pathological = pathological;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
