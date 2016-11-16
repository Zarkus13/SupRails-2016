/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.suprails.dao.jpa;

import com.supinfo.suprails.dao.CustomerOrderDao;
import com.supinfo.suprails.entity.CustomerOrder;
import java.io.Serializable;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author alexis
 */
@Stateless
public class JpaCustomerOrderDao implements CustomerOrderDao, Serializable {
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public CustomerOrder addCustomerOrder(CustomerOrder customerOrder) {
        em.persist(customerOrder);
        return customerOrder;
    }
    
}
