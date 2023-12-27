package com.springboot.assignment3.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sequelizemeta")
public class Sequelizemeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String name;

    public Sequelizemeta() {
    }

    public Sequelizemeta(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
