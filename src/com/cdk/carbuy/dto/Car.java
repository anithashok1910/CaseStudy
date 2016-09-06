package com.cdk.carbuy.dto;

import java.util.Arrays;

/**
 * Created by guptah on 9/1/2016.
 */


public class Car {
    private int id;
    private String make;
    private String model;
    private int year;
    private int price;
    private String[] description;
    private String imageURL;

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String[] getDescription() {
        return description;
    }

    public void setDescription(String[] description) {
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

    public Car(int id, String make, String model, int year,int price) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = year;
    }

    public Car() {
    }
    public Car(com.cdk.carbuy.domain.Car car){
        this.id = car.getId();
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
                ", price=" + price +
                ", description=" + Arrays.toString(description) +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }
}
