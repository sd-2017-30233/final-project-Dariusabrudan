package com.mkyong.rest;

import com.mkyong.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserService {

    @POST
    @Path("/post/addUser")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(User u) {
        String result = null;
        if (User.exists(u.getUserId())) {
            result = "User " + u.getUsername() + " exists ";
        } else {
            u.insert(u.getUserId(), u.getUsername(), u.getPassword(), u.getType());
            result = "User " + u.getUsername() + " added ";
        }
        return Response.status(201).entity(result).build();
    }

    @POST
    @Path("/post/updateUser")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(User u) {
        String result = null;
        if (!User.exists(u.getUserId())) {
            result = "User " + u.getUsername() + "don't exist ";
        } else {
            u.update(u.getUserId(), u.getUsername(), u.getPassword(), u.getType());
            result = "User " + u.getUsername() + " updated ";
        }
        return Response.status(201).entity(result).build();
    }

    @POST
    @Path("/post/deleteUser")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteUser(User u) {
        String result = null;
        if (!User.exists(u.getUserId())) {
            result = "User" +u.getUserId() + "don't exist";
        } else {
            u.delete(u.getUserId());
            result = "User " + u.getUserId() + " deleted ";
        }
        return Response.status(201).entity(result).build();
    }
}