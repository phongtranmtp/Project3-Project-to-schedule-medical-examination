package com.springboot.assignment3.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Table(name = "supporterlogs") // nhật kí ủng hộ
public class Supporterlog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "content")
    private String content;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "patientId")
    private Patient patient;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "supporterId")
    private User user;

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
}
