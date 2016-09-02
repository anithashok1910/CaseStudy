package com.cdk.carbuy.dao;

import com.cdk.carbuy.dto.Order;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by guptah on 9/1/2016.
 */
public class OrderDAO {
    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public Order addOrder(Order order) {
        com.cdk.carbuy.domain.Order domainOrder = new com.cdk.carbuy.domain.Order(order);
        order = new Order((com.cdk.carbuy.domain.Order)hibernateTemplate.save(domainOrder));
        return order;
    }

    public Order parseOrderRequest(String jsonString) throws FileNotFoundException {
         final String FILENAME = "C:\\Users\\ashoka\\Desktop\\Week 7\\TestCode\\src\\com\\company\\order.json";
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader(FILENAME));
        Order[]orders = gson.fromJson(reader, Order[].class);
        Order order = orders[0];
        return order;
    }
}
