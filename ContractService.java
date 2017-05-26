package com.mkyong.rest;

import com.mkyong.model.Contract;
import com.mkyong.model.Employee;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/contract")
public class ContractService {

        @POST
        @Consumes(MediaType.APPLICATION_JSON)
        public Response addContract(Contract c) {
            String result = null;
            if (Contract.exists(c.getContractId())) {
                result = "Contract " + c.getContractId() + " exists ";
            } else {
                c.insert(c.getContractId(),c.getDate(),c.getEmployeeId());
                result = "Contract " + c.getContractId() + " added ";
            }
            return Response.status(201).entity(result).build();
        }

        @PUT
        @Consumes(MediaType.APPLICATION_JSON)
        public Response updateContract(Contract c) {
            String result = null;
            if (!Contract.exists(c.getContractId())) {
                result = "Contract " + c.getContractId() + " don't exist ";
            } else {
                c.update(c.getContractId(),c.getDate(),c.getCarId(),c.getCustomerId(),c.getEmployeeId());
                result = "Contract " + c.getContractId() + " updated ";
            }
            return Response.status(201).entity(result).build();
        }

    @PUT
    @Path("/parts")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateContractWithDetails(Contract c) {
        String result = null;
        c.updateParts(c.getCustomerId(),c.getDetails());
        result = "Contract for the customer " + c.getCustomerId() + " updated with additional parts requested by the customer ";
        return Response.status(201).entity(result).build();
    }
    }
