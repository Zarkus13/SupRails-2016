package com.supinfo.suprails.rest;

import com.supinfo.suprails.entity.CreateOrder;
import com.supinfo.suprails.entity.Customer;
import com.supinfo.suprails.entity.CustomerOrder;
import com.supinfo.suprails.service.CustomerOrderService;
import com.supinfo.suprails.service.TripService;

import javax.ejb.EJB;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * Created by Alexis on 16/11/2016.
 */
@Path("/orders")
public class CustomerOrdersApi {

    @EJB
    private CustomerOrderService customerOrderService;

    @EJB
    private TripService tripService;

    @POST
    public Response processOrder(CreateOrder createOrder) {
        Customer customer = new Customer(
            createOrder.getFirstname(),
            createOrder.getLastname(),
            createOrder.getEmail()
        );

        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setCustomer(customer);
        customerOrder.setTrip(tripService.findTripById(createOrder.getTripId()));

        customerOrderService.processCustomerOrder(customerOrder);

        return Response.accepted().build();
    }

}
