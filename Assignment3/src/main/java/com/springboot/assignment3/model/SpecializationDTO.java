package com.springboot.assignment3.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

public class SpecializationDTO {
    private int id;

    private String name;

    private String description;

    private String image;

    private int numberChoose;

    private int numberSearch;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

    public SpecializationDTO() {
    }

    public SpecializationDTO(String name, String description,int numberSearch,int numberChoose,
                             String image, Date createdAt, Date updatedAt, Date deletedAt) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.numberChoose = numberChoose;
        this.numberSearch = numberSearch;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public int getNumberChoose() {
        return numberChoose;
    }

    public void setNumberChoose(int numberChoose) {
        this.numberChoose = numberChoose;
    }

    public int getNumberSearch() {
        return numberSearch;
    }

    public void setNumberSearch(int numberSearch) {
        this.numberSearch = numberSearch;
    }
}
