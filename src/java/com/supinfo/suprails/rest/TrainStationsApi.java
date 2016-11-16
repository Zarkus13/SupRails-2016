package com.supinfo.suprails.rest;

import com.supinfo.suprails.entity.TrainStation;
import com.supinfo.suprails.service.TrainStationService;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Alexis on 16/11/2016.
 */
@Path("/stations")
public class TrainStationsApi {

    @EJB
    private TrainStationService trainStationService;

    @GET
    public List<TrainStation> listTrainStations() {
        return trainStationService.getAllTrainStations();
    }

    @POST
    public Response addTrainStation(TrainStation station) {
        trainStationService.addTrainStation(station);

        return Response.accepted().build();
    }

}
