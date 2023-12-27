package com.springboot.assignment3.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "patients") // nguoi benh
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "doctorId")
    @JsonIgnore
    private DoctorUser doctorUser;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "statusId")
    private Status status;

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = {CascadeType.DETACH,CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "patientId")
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "patient")
    private List<Schedule> schedule;

    @OneToOne(mappedBy = "patient")
    private Extrainfo extrainfo;


    public Patient() {
    }

    public Patient(DoctorUser doctorUser, Status status, String name,User user,Extrainfo extrainfo) {
        this.doctorUser = doctorUser;
        this.status = status;
        this.extrainfo = extrainfo;
        this.name = name;
        this.user = user;
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

    public Extrainfo getExtrainfo() {
        return extrainfo;
    }

    public void setExtrainfo(Extrainfo extrainfo) {
        this.extrainfo = extrainfo;
    }

    public List<Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Schedule> schedule) {
        this.schedule = schedule;
    }
}
