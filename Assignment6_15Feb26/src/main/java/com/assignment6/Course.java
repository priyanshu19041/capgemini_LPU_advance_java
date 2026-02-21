package com.assignment6;

import jakarta.persistence.*;

@Entity
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private int credits;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public int getCredits() { return credits; }
    public void setCredits(int credits) { this.credits = credits; }
}