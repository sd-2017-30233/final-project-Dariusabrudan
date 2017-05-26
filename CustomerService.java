package com.mkyong.rest;

import com.mkyong.model.Customer;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/customer")
public class CustomerService {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCustomer(Customer c) {
        String result = null;
        if (Customer.exists(c.getCustomerId())) {
            result = "Customer " + c.getName() + " exists ";
        } else {
            c.insert(c.getCustomerId(), c.getName(), c.getUsername(), c.getIdentityCardNumber(), c.getCnp(), c.getAddress(),c.getPassword());
            result = "Customer " + c.getName() + " added ";
        }
        return Response.status(201).entity(result).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCustomer(Customer c) {
        String result = null;
        if (!Customer.exists(c.getCustomerId())) {
            result = "Customer " + c.getName() + "don't exist ";
        } else {
            c.update(c.getCustomerId(), c.getName(), c.getUsername(), c.getIdentityCardNumber(), c.getCnp(), c.getAddress(), c.getPassword());
            result = "Customer " + c.getName() + " updated ";
        }
        return Response.status(201).entity(result).build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteCustomer(Customer c) {
        String result = null;
        if (!Customer.exists(c.getCustomerId())) {
            result = "Customer " + c.getCustomerId() + " don't exist";
        } else {
            c.delete(c.getCustomerId());
            result = "Customer " + c.getCustomerId() + " deleted ";
        }
        return Response.status(201).entity(result).build();
    }
}