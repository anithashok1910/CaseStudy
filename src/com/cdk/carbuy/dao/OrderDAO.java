package com.cdk.carbuy.dao;

import com.cdk.carbuy.dto.Order;
import org.springframework.orm.hibernate3.HibernateTemplate;

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
        hibernateTemplate.save(domainOrder);
        return order;
    }
}
