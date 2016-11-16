package com.supinfo.suprails.rest;

import com.supinfo.suprails.entity.Trip;
import com.supinfo.suprails.service.TripService;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

/**
 * Created by Alexis on 16/11/2016.
 */
@Path("/trips")
public class TripsApi {

    @EJB
    private TripService tripService;

    @GET
    public List<Trip> listTrips() {
        return tripService.getAllTrips();
    }

}
