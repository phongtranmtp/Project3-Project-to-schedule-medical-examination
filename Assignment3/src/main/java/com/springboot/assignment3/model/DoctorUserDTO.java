package com.springboot.assignment3.model;

import com.springboot.assignment3.entity.Clinic;
import com.springboot.assignment3.entity.Comment;
import com.springboot.assignment3.entity.Specialization;
import com.springboot.assignment3.entity.User;
import jakarta.persistence.*;

import java.util.Date;

public class DoctorUserDTO {
    private int id;

    private String name;

    private String generalIntroduction;

    private String trainingProcess;

    private String achievementsAchieved;

    private String specialtiesInCharge;

    private User user;

    private Clinic clinic;

    private Comment comment;

    private Specialization specialization;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

    public DoctorUserDTO() {
    }

    public DoctorUserDTO(String generalIntroduction, String trainingProcess,Comment comment,
                         String achievementsAchieved, String specialtiesInCharge,
                         User user, Clinic clinic, Specialization specialization,
                         Date createdAt, Date updatedAt, Date deletedAt) {
        this.generalIntroduction = generalIntroduction;
        this.trainingProcess = trainingProcess;
        this.achievementsAchieved = achievementsAchieved;
        this.specialtiesInCharge = specialtiesInCharge;
        this.user = user;
        this.clinic = clinic;
        this.comment = comment;
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

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
