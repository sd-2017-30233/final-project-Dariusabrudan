package com.mkyong.rest;

import com.mkyong.model.Employee;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/employee")
public class EmployeeService {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addEmployee(Employee e) {
        String result = null;
        if (Employee.exists(e.getEmployeeId())) {
            result = "Employee " + e.getName() + " exists ";
        } else {
            e.insert(e.getEmployeeId(), e.getName(), e.getUsername(), e.getGenre(), e.getHireDate(), e.getPassword());
            result = "Employee " + e.getName() + " added ";
        }
        return Response.status(201).entity(result).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateEmployee(Employee e) {
        String result = null;
        if (!Employee.exists(e.getEmployeeId())) {
            result = "Employee " + e.getName() + "don't exist ";
        } else {
            e.update(e.getEmployeeId(), e.getName(), e.getUsername(), e.getGenre(), e.getHireDate(), e.getPassword());
            result = "Employee " + e.getName() + " updated ";
        }
        return Response.status(201).entity(result).build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteEmployee(Employee e) {
        String result = null;
        if (!Employee.exists(e.getEmployeeId())) {
            result = "Employee " + e.getEmployeeId() + " don't exist";
        } else {
            e.delete(e.getEmployeeId());
            result = "Employee " + e.getEmployeeId() + " deleted ";
        }
        return Response.status(201).entity(result).build();
    }
}