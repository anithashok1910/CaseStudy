package com.cdk.carbuy.domain;

import javax.persistence.*;

/**
 * Created by guptah on 9/1/2016.
 */
@Entity
@Table(name = "car_t")
public class Car {
    @Column(name = "id")
    private int id;
    @Column(name = "make")
    private String make;
    @Column(name = "model")
    private String model;
    @Column(name = "year")
    private int year;
    @Column(name = "price")
    private int price;
    private String description;

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Car() {
    }

    public Car(com.cdk.carbuy.dto.Car car){
        this.make = car.getMake();
        this.model = car.getMake();
        this.id = car.getId();
        this.year = car.getYear();
        this.price = car.getPrice();
    }
    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", description=" + description +
                '}';
    }
}