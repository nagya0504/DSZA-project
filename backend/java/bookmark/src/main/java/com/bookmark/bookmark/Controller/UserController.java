/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.bookmark.bookmark.Controller;

import com.bookmark.bookmark.Modell.User;
import com.bookmark.bookmark.Service.UserService;
import com.bookmart.bookmark.util.Token;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 * REST Web Service
 *
 * @author nagya
 */
@Path("user")
public class UserController {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UserController
     */
    public UserController() {
    }

    /**
     * Retrieves representation of an instance of com.bookmark.bookmark.Controller.UserController
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    
//    C(R)UD
    
//    @GET
//    @Path("/selectAllUser")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response selectAllUser(User u){
//        String result = UserService.selectAllUser();
//        return Response.status(Response.Status.OK).entity(result).type(MediaType.APPLICATION_JSON).build();
//    }
    
//    @GET
//    @Path("/selectAllAdmin")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response selectAllAdmin(User u){
//        String result = UserService.selectAllAdmin();
//        return Response.status(Response.Status.OK).entity(result).type(MediaType.APPLICATION_JSON).build();
//    }
    
//    CRU(D)
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    @PUT
    @Path("/deleteUser")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteUser(User u){
        String result = UserService.deleteUser(u.getId());
        return Response.status(Response.Status.OK).entity(result).type(MediaType.APPLICATION_JSON).build();
    }
    
//    (C)RUD + LOGIN
    
//    @POST
//    @Path("/login")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response login(User u){
//        String result = UserService.login(u.getEmail(), u.getPwd());
//        return Response.status(Response.Status.OK).entity(result).type(MediaType.APPLICATION_JSON).build();
//    }
    
    @POST
    @Path("/addUser")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(User u){
        String result = UserService.addUser(u.getUsername(), u.getFamilyName(), u.getGivenName(), u.getEmail(), u.getPwd(), u.getPhone(), u.getTown());
        return Response.status(Response.Status.OK).entity(result).type(MediaType.APPLICATION_JSON).build();
    }
    
//    @POST
//    @Path("/addAdmin")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response addAdmin(User u){
//        String result = UserService.addAdmin(u.getUsername(), u.getFamilyName(), u.getGivenName(), u.getEmail(), u.getPwd(), u.getPhone(), u.getTown());
//        return Response.status(Response.Status.OK).entity(result).type(MediaType.APPLICATION_JSON).build();
//    }
    
//    CR(U)D

    @POST
    @Path("/updateUserPassword")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUserPassword(User u){
        String result = UserService.updateUserPassword(u.getId(), u.getPwd());
        return Response.status(Response.Status.OK).entity(result).type(MediaType.APPLICATION_JSON).build();
    }
    
    @POST
    @Path("/updateUserPhone")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUserPhone(User u){
        String result = UserService.updateUserPhone(u.getId(), u.getPhone());
        return Response.status(Response.Status.OK).entity(result).type(MediaType.APPLICATION_JSON).build();
    }
    
    @POST
    @Path("/updateUserTown")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUserTown(User u){
        String result = UserService.updateUserTown(u.getId(), u.getTown());
        return Response.status(Response.Status.OK).entity(result).type(MediaType.APPLICATION_JSON).build();
    }
    
    @POST
    @Path("/updateUserUsername")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUserUsername(User u){
        String result = UserService.updateUserUsername(u.getId(), u.getUsername());
        return Response.status(Response.Status.OK).entity(result).type(MediaType.APPLICATION_JSON).build();
    }
    
    @POST
    @Path("/logDeleteUser")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response logDeleteUser(User u){
        String result = UserService.logDeleteUser(u.getId());
        return Response.status(Response.Status.OK).entity(result).type(MediaType.APPLICATION_JSON).build();
    }
    
    @POST
    @Path("/selectUserByEmail")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response selectUserByEmail(User u){
        try {
        User user = UserService.selectUserByEmail(u.getEmail(), u.getPwd());

        if (user != null) {
            int userId = user.getId();
            String username = user.getUsername();
            String familyName = user.getFamilyName();
            String givenName = user.getGivenName();
            String email = user.getEmail();
            String phone = user.getPhone();
            String town = user.getTown();
            int role = user.getRoleId();

            JsonObject result = Json.createObjectBuilder()
                .add("userId", userId)
                .add("username", username)
                .add("familyName", familyName)
                .add("givenName", givenName)
                .add("email", email)
                .add("phone", phone)
                .add("town", town)
                .add("role", role)
                .add("token", Token.createToken(user))
                .build();

            return Response.status(Response.Status.OK).entity(result).type(MediaType.APPLICATION_JSON).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED)
                .entity("Helytelen email vagy jelszó").type(MediaType.APPLICATION_JSON).build();
        }
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error").type(MediaType.APPLICATION_JSON).build();
        }
    }
    
}
