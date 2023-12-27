package com.springboot.assignment3.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Table(name = "doctor_users")
public class DoctorUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "general_introduction")
    private String generalIntroduction;

    @Column(name = "training_process")
    private String trainingProcess;

    @Column(name = "achievements_achieved")
    private String achievementsAchieved;

    @Column(name = "specialties_in_charge")
    private String specialtiesInCharge;

    @OneToOne(cascade = {CascadeType.DETACH,CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "doctorId")
    private User user;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "clinicId")
    private Clinic clinic;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "specializationId")
    private Specialization specialization;

    @Column(name = "createdAt")
    private Date createdAt;

    @Column(name = "updatedAt")
    private Date updatedAt;

    @Column(name = "deletedAt")
    private Date deletedAt;

    public DoctorUser() {
    }

    public DoctorUser(String generalIntroduction, String trainingProcess,
                      String achievementsAchieved, String specialtiesInCharge,
                      User user, Clinic clinic, Specialization specialization,
                      Date createdAt, Date updatedAt, Date deletedAt) {
        this.generalIntroduction = generalIntroduction;
        this.trainingProcess = trainingProcess;
        this.achievementsAchieved = achievementsAchieved;
        this.specialtiesInCharge = specialtiesInCharge;
        this.user = user;
        this.clinic = clinic;
        this.specialization = specialization;
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

    public String getGeneralIntroduction() {
        return generalIntroduction;
    }

    public void setGeneralIntroduction(String generalIntroduction) {
        this.generalIntroduction = generalIntroduction;
    }

    public String getTrainingProcess() {
        return trainingProcess;
    }

    public void setTrainingProcess(String trainingProcess) {
        this.trainingProcess = trainingProcess;
    }

    public String getAchievementsAchieved() {
        return achievementsAchieved;
    }

    public void setAchievementsAchieved(String achievementsAchieved) {
        this.achievementsAchieved = achievementsAchieved;
    }

    public String getSpecialtiesInCharge() {
        return specialtiesInCharge;
    }

    public void setSpecialtiesInCharge(String specialtiesInCharge) {
        this.specialtiesInCharge = specialtiesInCharge;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
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
}
