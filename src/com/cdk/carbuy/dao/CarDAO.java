package com.cdk.carbuy.dao;


import com.cdk.carbuy.domain.Car;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by ashoka on 9/1/2016.
 */
@Component
public class CarDAO {
    String FILENAME = "C:\\Users\\ashoka\\Desktop\\Week 7\\Case-Study\\mock-data\\cars.json";

    public ArrayList<com.cdk.carbuy.dto.Car> getCarData() throws FileNotFoundException {
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader(FILENAME));
        Car cars[] = gson.fromJson(reader, Car[].class);
        ArrayList<com.cdk.carbuy.dto.Car> carList = new ArrayList<>();
        for(int i = 0; i<cars.length;i++){
            com.cdk.carbuy.dto.Car car = new com.cdk.carbuy.dto.Car();
            car.setId(cars[i].getId());
            car.setMake(cars[i].getMake());
            car.setModel(cars[i].getModel());
            car.setYear(cars[i].getYear());
            car.setPrice(cars[i].getPrice());
            car.setDescription(cars[i].getDescription());
            carList.add(car);
        }
        return carList;
    }


    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public Car addCar(Car car) {
        hibernateTemplate.save(car);
        return car;


    }

    public Car get(int carID) {
        return (Car) hibernateTemplate.get(Car.class,carID);



    }
}
