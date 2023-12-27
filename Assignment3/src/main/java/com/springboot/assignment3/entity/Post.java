package com.springboot.assignment3.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "contentMarkdown")
    private String contentMarkdown;

    @Column(name = "contentHTML")
    private String contentHTML;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "forDoctorId")
    private DoctorUser doctorUser;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "forSpecializationId")
    private Specialization specialization;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "forClinicId")
    private Clinic clinic;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "writeId")
    private User user;

    @Column(name = "confirmByDoctor")
    private boolean confirmByDoctor ;

    @Column(name = "image")
    private String image;

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

    public Post() {
    }

    public Post(String title, String contentMarkdown, String contentHTML,
                DoctorUser doctorUser, Specialization specialization, Clinic clinic,
                User user, boolean confirmByDoctor, String image, Date createdAt,
                Date updatedAt, Date deletedAt) {
        this.title = title;
        this.contentMarkdown = contentMarkdown;
        this.contentHTML = contentHTML;
        this.doctorUser = doctorUser;
        this.specialization = specialization;
        this.clinic = clinic;
        this.user = user;
        this.confirmByDoctor = confirmByDoctor;
        this.image = image;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContentMarkdown() {
        return contentMarkdown;
    }

    public void setContentMarkdown(String contentMarkdown) {
        this.contentMarkdown = contentMarkdown;
    }

    public String getContentHTML() {
        return contentHTML;
    }

    public void setContentHTML(String contentHTML) {
        this.contentHTML = contentHTML;
    }

    public DoctorUser getDoctorUser() {
        return doctorUser;
    }

    public void setDoctorUser(DoctorUser doctorUser) {
        this.doctorUser = doctorUser;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isConfirmByDoctor() {
        return confirmByDoctor;
    }

    public void setConfirmByDoctor(boolean confirmByDoctor) {
        this.confirmByDoctor = confirmByDoctor;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
