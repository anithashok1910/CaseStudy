package com.cdk.carbuy.controller;

import com.cdk.carbuy.dao.CarDAO;
import com.cdk.carbuy.dao.OrderDAO;
import com.cdk.carbuy.dto.Car;
import com.cdk.carbuy.dto.Customer;
import com.cdk.carbuy.dto.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Created by ashoka on 9/1/2016.
 */
@Controller
public class CarController {
    @Autowired
    private CarDAO carDAO = null;

    public CarDAO getCarDAO() {
        return carDAO;
    }

    public void setCarDAO(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @Autowired
    private OrderDAO orderDAO= null;

    public OrderDAO getOrderDAO() {
        return orderDAO;
    }

    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public @ResponseBody ArrayList<Car> getCarListings(HttpServletRequest request, HttpServletResponse response){
        ArrayList<Car> carList = null;
        try {
            carList = carDAO.getCarData();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return carList;
        }
    }
    @RequestMapping(value = "/placeOrder",method = RequestMethod.GET)
    public @ResponseBody Order placeOrder(HttpServletRequest request, HttpServletResponse response,@RequestParam ("car")Car car,@RequestParam ("customer") Customer customer){
        System.out.println(customer.toString());
        System.out.println(car.toString());
        Order order = new Order();
        order.setCustomer(customer);
        order.setCar(car);
        order=orderDAO.addOrder(order);
        return order;
    }

}

