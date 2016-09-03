package com.cdk.carbuy.controller;

import com.cdk.carbuy.dao.CarDAO;
import com.cdk.carbuy.dao.OrderDAO;
import com.cdk.carbuy.dto.Car;
import com.cdk.carbuy.dto.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
    private CarDAO carDAO;

    public CarDAO getCarDAO() {
        return carDAO;
    }

    public void setCarDAO(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @Autowired
    private OrderDAO orderDAO;

    public OrderDAO getOrderDAO() {
        return orderDAO;
    }

    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @RequestMapping(value = "/list.do",method = RequestMethod.GET)
    public @ResponseBody ArrayList<Car> getCarListings(HttpServletRequest request, HttpServletResponse response){
        ArrayList<Car> carList = null;
        try {
            carList = carDAO.getCarData();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            return carList;
        }
    }
    @RequestMapping(value = "/placeOrder.do",method = RequestMethod.GET)
    public @ResponseBody Order placeOrder(HttpServletRequest request,HttpServletResponse response,String jsonString){
        com.cdk.carbuy.dto.Order order = null;
        try {
            order = orderDAO.parseOrderRequest(jsonString);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            order=orderDAO.addOrder(order);
            return order;
        }

    }

}
