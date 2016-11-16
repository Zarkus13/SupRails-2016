/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.suprails.soap;

import com.supinfo.suprails.entity.Customer;
import com.supinfo.suprails.entity.CustomerOrder;
import com.supinfo.suprails.entity.Trip;
import com.supinfo.suprails.service.CustomerOrderService;
import com.supinfo.suprails.service.TripService;

import javax.ejb.EJB;
import javax.jws.WebService;
import java.util.List;

/**
 *
 * @author alexis
 */
@WebService(
    name = "TripWS",
    serviceName = "TripWSService",
    targetNamespace = "http://supinfo.com/soap"
)
public class TripWS {
    
    @EJB
    private TripService tripService;
    
    @EJB
    private CustomerOrderService customerOrderService;
    
    public List<Trip> getAllTrips() {
        return tripService.getAllTrips();
    }
    
    public CustomerOrder processOrder(Long tripId, String firstname, String lastname, String email) {
        Customer customer = new Customer(firstname, lastname, email);
        
        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setCustomer(customer);
        customerOrder.setTrip(tripService.findTripById(tripId));
        
        return customerOrderService.processCustomerOrder(customerOrder);
    }
    
}
