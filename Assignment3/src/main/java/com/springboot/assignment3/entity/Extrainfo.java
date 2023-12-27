package com.springboot.assignment3.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Table(name = "extrainfos") // thjong tin bo sung
public class Extrainfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "patientId")
    private Patient patient;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "placeId")
    private Place place;

    @Column(name = "historyBreath")
    private String historyBreath;

    @Column(name = "oldForms")
    private String oldForms;

    @Column(name = "sendForms")
    private String sendForms;

    @Column(name = "moreInfo")
    private String moreInfo;

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

    public Extrainfo() {
    }

    public Extrainfo(Patient patient, Place place, String historyBreath,
                     String oldForms, String sendForms, String moreInfo,
                     Date createdAt, Date updatedAt, Date deletedAt) {
        this.patient = patient;
        this.place = place;
        this.historyBreath = historyBreath;
        this.oldForms = oldForms;
        this.sendForms = sendForms;
        this.moreInfo = moreInfo;
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

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public String getHistoryBreath() {
        return historyBreath;
    }

    public void setHistoryBreath(String historyBreath) {
        this.historyBreath = historyBreath;
    }

    public String getOldForms() {
        return oldForms;
    }

    public void setOldForms(String oldForms) {
        this.oldForms = oldForms;
    }

    public String getSendForms() {
        return sendForms;
    }

    public void setSendForms(String sendForms) {
        this.sendForms = sendForms;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
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
