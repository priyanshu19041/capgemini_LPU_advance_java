package com.assignment6;

import jakarta.persistence.*;

@Entity
public class InstructorProfile {

    @Id
    @GeneratedValue
    private Long id;

    private String officeRoom;
    private String phone;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getOfficeRoom() { return officeRoom; }
    public void setOfficeRoom(String officeRoom) { this.officeRoom = officeRoom; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}