package com.mkyong.rest;

import com.mkyong.model.ICar;
import com.mkyong.model.ProxyCar;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.Proxy;

@Path("/car")
public class CarService {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCar(ProxyCar c) {
        String result = null;
        if (c.exists(c.getCarId())) {
            result = "Car " + c.getMake() + " " + c.getModel() + " exists ";
        } else {
            c.insert(c.getCarId(), c.getMake(), c.getModel(), c.getYear(), c.getHorsePower(), c.getFuelConsumption(), c.getPrice());
            result = "Car " + c.getMake() + " " + c.getModel() + " added ";
        }
        return Response.status(201).entity(result).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCar(ProxyCar c) {
        String result = null;
        if (!c.exists(c.getCarId())) {
            result = "Car " + c.getMake() + " " + c.getModel() + "don't exist ";
        } else {
            c.update(c.getCarId(), c.getMake(), c.getModel(), c.getYear(), c.getHorsePower(), c.getFuelConsumption(), c.getPrice());
            result = "Car " + c.getMake() + " " + c.getModel() + " updated ";
        }
        return Response.status(201).entity(result).build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteCar(ProxyCar c) {
        String result = null;
        if (!c.exists(c.getCarId())) {
            result = "Car " + c.getCarId() + " don't exist";
        } else {
            c.delete(c.getCarId());
            result = "Car " + c.getCarId() + " deleted ";
        }
        return Response.status(201).entity(result).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public boolean viewCars() {
        ICar c=new ProxyCar();
        if(c.viewCars())
            return true;
        else return false;
    }

    @GET
    @Path("{make}/{model}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean searchByMakeAndModel(@PathParam("make") String make,
                                @PathParam("model") String model
    ) {
        ICar c=new ProxyCar();
        if(c.searchByMake(make,model))
            return true;
        else return false;
    }
}