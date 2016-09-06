package com.cdk.carbuy.dao;

import com.cdk.carbuy.dto.Order;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by guptah on 9/1/2016.
 */
@Component
public class OrderDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public Order addOrder(Order order) {
        com.cdk.carbuy.domain.Order domainOrder = new com.cdk.carbuy.domain.Order(order);
        hibernateTemplate.save(domainOrder);
        order = new Order(domainOrder);
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
