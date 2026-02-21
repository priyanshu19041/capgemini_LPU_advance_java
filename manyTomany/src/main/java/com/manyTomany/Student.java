package com.manyTomany;
import javax.persistence.*;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String gender;
    private String branch;

    @ManyToMany
    @JoinTable(
        name = "student_subject",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<Subject> subjects;

    public Student() {}

    public Student(String name, String gender,
                   String branch, List<Subject> subjects) {
        this.name = name;
        this.gender = gender;
        this.branch = branch;
        this.subjects = subjects;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getBranch() { return branch; }
    public void setBranch(String branch) { this.branch = branch; }

    public List<Subject> getSubjects() { return subjects; }
    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}