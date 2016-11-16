/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.suprails.service;

import com.supinfo.suprails.dao.CustomerOrderDao;
import com.supinfo.suprails.entity.CustomerOrder;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author alexis
 */
@Stateless
public class CustomerOrderService {
    
    @EJB
    private CustomerOrderDao customerOrderDao;
    
    public CustomerOrder processCustomerOrder(CustomerOrder customerOrder) {
        
        sendMail(
            "Processing customer order : " + customerOrder.getCustomer().getEmail() + 
            " - From " + customerOrder.getTrip().getDepartureStation().getName() + 
            " to " + customerOrder.getTrip().getArrivalStation().getName()
        );
        
        return customerOrderDao.addCustomerOrder(customerOrder);
    }
    
    @Asynchronous
    public void sendMail(String msg) {
        System.out.println("Send email : " + msg);
    }
    
}
