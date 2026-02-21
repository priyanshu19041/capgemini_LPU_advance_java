package com.assignment6;


import jakarta.persistence.*;
import java.util.List;

@Entity
public class Instructor {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String department;

    @OneToOne
    private InstructorProfile instructorProfile;

    @OneToMany
    private List<Course> courses;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public InstructorProfile getInstructorProfile() { return instructorProfile; }
    public void setInstructorProfile(InstructorProfile instructorProfile) { this.instructorProfile = instructorProfile; }

    public List<Course> getCourses() { return courses; }
    public void setCourses(List<Course> courses) { this.courses = courses; }
}