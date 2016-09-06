package com.cdk.carbuy.controller;

import com.cdk.carbuy.dao.CarDAO;
import com.cdk.carbuy.dao.OrderDAO;
import com.cdk.carbuy.dto.Car;
import com.cdk.carbuy.dto.Customer;
import com.cdk.carbuy.dto.Order;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
    @RequestMapping(value = "/placeOrder",method = RequestMethod.POST)
    public @ResponseBody String placeOrder(HttpServletRequest request, HttpServletResponse response)
    {
        System.out.println("hello");
        Car car = new Car();
        car.setId(Integer.parseInt(request.getParameter("carId")));
        car.setModel(request.getParameter("model"));
        car.setMake(request.getParameter("make"));
        car.setPrice(Integer.parseInt(request.getParameter("price")));
        car.setYear(Integer.parseInt(request.getParameter("year")));
        System.out.println(car.toString());
        System.out.println("hello 2");
        Customer customer = new Customer();
        customer.setName(request.getParameter("name"));
        System.out.println("hello 3");
        customer.setAddress(request.getParameter("address"));
        System.out.println("hello 4");
        customer.setEmail(request.getParameter("email"));
        System.out.println("hello 5");
        customer.setMob_no(Long.parseLong(request.getParameter("mob_no")));
        System.out.println("hello 6");
        System.out.println(customer.toString());
        Order order = new Order();
        order.setCustomer(customer);
        order.setCar(car);
        System.out.println(order.toString());
        order=orderDAO.addOrder(order);
        Gson gson = new Gson();
        return gson.toJson(order);
    }

}

