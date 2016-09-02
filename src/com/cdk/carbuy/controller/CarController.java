package com.cdk.carbuy.controller;

import com.cdk.carbuy.dao.CarDAO;
import com.cdk.carbuy.dto.Car;
import com.cdk.carbuy.dto.Order;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Created by ashoka on 9/1/2016.
 */

public class CarController {
    @RequestMapping(value = "/list.do",method = RequestMethod.GET)
    public ArrayList<Car> generateData(HttpServletRequest request, HttpServletResponse response){
        ArrayList<Car> carList = null;
        try {
            carList = CarDAO.getCarData();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            return carList;
        }
    }

    public Order placeOrder(){
        com.cdk.carbuy.dto.Order order = null;
        return order;
    }

}
