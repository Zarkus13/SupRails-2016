/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.suprails.service;

import com.supinfo.suprails.dao.CustomerOrderDao;
import com.supinfo.suprails.entity.CustomerOrder;

import javax.annotation.Resource;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jms.*;

/**
 *
 * @author alexis
 */
@Stateless
public class CustomerOrderService {
    
    @EJB
    private CustomerOrderDao customerOrderDao;

    @Resource(mappedName = "jms/SupRailsConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(mappedName = "queue/SupRails")
    private Destination destination;
    
    public CustomerOrder processCustomerOrder(CustomerOrder customerOrder) {

        try {
            System.out.println("connectionFactory : " + connectionFactory);
            System.out.println("destination : " + destination);
            Connection cnt = connectionFactory.createConnection();
            Session session = cnt.createSession(false, Session.AUTO_ACKNOWLEDGE);

            MessageProducer producer = session.createProducer(destination);

            TextMessage msg = session.createTextMessage("PRINT THIS TICKET B*TCH !");

            producer.send(msg);

            System.out.println("message sent !");

            cnt.close();
        }
        catch (Exception e) {
            System.out.println("Error during message sending : " + e.getMessage());
        }
        
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
