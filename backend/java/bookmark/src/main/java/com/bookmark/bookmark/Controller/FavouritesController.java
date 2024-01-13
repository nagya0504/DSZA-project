/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookmark.bookmark.Controller;

import com.bookmark.bookmark.Modell.Favourites;
import com.bookmark.bookmark.Service.FavouritesService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author nagya
 */
@Path("/favourite")
public class FavouritesController {
    
    @PUT
    @Path("/deleteFav")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteFav(Favourites f){
        String result = FavouritesService.deleteFav(f.getUserId(), f.getProductId());
        return Response.status(Response.Status.OK).entity(result).type(MediaType.APPLICATION_JSON).build();
    }
    
    @POST
    @Path("/addFav")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addFav(Favourites f){
        String result = FavouritesService.addFav(f.getUserId(), f.getProductId());
        return Response.status(Response.Status.OK).entity(result).type(MediaType.APPLICATION_JSON).build();
    }
    
    @POST
    @Path("/selectAllFav")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response selectAllFav(Favourites f){
        List<Favourites> result = FavouritesService.selectAllFav(f.getUserId());
        return Response.status(Response.Status.OK).entity(result).type(MediaType.APPLICATION_JSON).build();
    }
}
