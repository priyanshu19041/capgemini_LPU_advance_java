package com.onetoonemapping;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

@Entity
public class Car {

    @Id
    private int id;
    private String brand;
    private String model;
    private String modelYear;
    private double price;

    @OneToOne
    @JoinColumn(name = "engine_id")
    private Engine engine;

    // getters & setters
}
