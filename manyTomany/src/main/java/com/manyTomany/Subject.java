package com.manyTomany;



import javax.persistence.*;
import java.util.List;

@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int noOfDays;

    @ManyToMany(mappedBy = "subjects")
    private List<Student> students;

    public Subject() {}

    public Subject(String name, int noOfDays) {
        this.name = name;
        this.noOfDays = noOfDays;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getNoOfDays() { return noOfDays; }
    public void setNoOfDays(int noOfDays) { this.noOfDays = noOfDays; }

    public List<Student> getStudents() { return students; }
    public void setStudents(List<Student> students) {
        this.students = students;
    }
}

