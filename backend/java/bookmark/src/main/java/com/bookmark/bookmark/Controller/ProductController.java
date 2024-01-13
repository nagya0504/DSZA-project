/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookmark.bookmark.Controller;

import com.bookmark.bookmark.Modell.Product;
import com.bookmark.bookmark.Service.ProductService;
import java.util.List;
import javax.json.Json;
import javax.json.JsonObject;
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
@Path("/product")
public class ProductController {
    
    @POST
    @Path("/addBook")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBook(Product p){
        String result = ProductService.addBook(p.getUserId(), p.getTitle(), p.getAuthor(), p.getPrice(), p.getDescription(), p.getImage());
        return Response.status(Response.Status.OK).entity(result).type(MediaType.APPLICATION_JSON).build();
    }
    
    @PUT
    @Path("/deleteBook")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteBook(Product p){
        String result = ProductService.deleteBook(p.getId());
        return Response.status(Response.Status.OK).entity(result).type(MediaType.APPLICATION_JSON).build();
    }
    
    @GET
    @Path("/orderBooksAZ")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response orderBooksAZ(Product p){
        List<Product> result = ProductService.orderBooksAZ();
        return Response.status(Response.Status.OK).entity(result).type(MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/orderBooksZA")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response orderBooksZA(Product p){
        String result = ProductService.orderBooksZA();
        return Response.status(Response.Status.OK).entity(result).type(MediaType.APPLICATION_JSON).build();
    }
    
    @GET
    @Path("/orderBooksAsc")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response orderBooksAsc(Product p){
        List<Product> result = ProductService.orderBooksAsc();
        return Response.status(Response.Status.OK).entity(result).type(MediaType.APPLICATION_JSON).build();
    }
    
    @GET
    @Path("/orderBooksDesc")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response orderBooksDesc(Product p){
        List<Product> result = ProductService.orderBooksDesc();
        return Response.status(Response.Status.OK).entity(result).type(MediaType.APPLICATION_JSON).build();
    }
    
    @GET
    @Path("/selectAllBooks")
    @Produces(MediaType.APPLICATION_JSON)
    public Response selectAllBooks(){
        List<Product> result = ProductService.selectAllBooks();
        return Response.status(Response.Status.OK).entity(result).type(MediaType.APPLICATION_JSON).build();
    }
    
    @GET
    @Path("/selectProduct")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response selectProduct(Product p){
        try {
        Product product = ProductService.selectProduct(p.getId());

        if (product != null) {
            int productId = product.getId();
            int userId = product.getUserId();
            String title = product.getTitle();
            String author = product.getAuthor();
            int price = product.getPrice();
            String desc = product.getDescription();
            String img = product.getImage();

            JsonObject result = Json.createObjectBuilder()
                .add("productId", productId)
                .add("userId", userId)
                .add("title", title)
                .add("author", author)
                .add("price", price)
                .add("desc", desc)
                .add("img", img)
                .build();

            return Response.status(Response.Status.OK).entity(result).type(MediaType.APPLICATION_JSON).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED)
                .entity("Ez a termék nem létezik").type(MediaType.APPLICATION_JSON).build();
        }
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error").type(MediaType.APPLICATION_JSON).build();
        }
    }
    
    @POST
    @Path("/updateBookAuthor")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBookAuthor(Product p){
        String result = ProductService.updateBookAuthor(p.getId(), p.getAuthor());
        return Response.status(Response.Status.OK).entity(result).type(MediaType.APPLICATION_JSON).build();
    }
    
    @POST
    @Path("/updateBookDesc")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBookDesc(Product p){
        String result = ProductService.updateBookDesc(p.getId(), p.getDescription());
        return Response.status(Response.Status.OK).entity(result).type(MediaType.APPLICATION_JSON).build();
    }
    
    @POST
    @Path("/updateBookImg")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBookImg(Product p){
        String result = ProductService.updateBookImg(p.getId(), p.getImage());
        return Response.status(Response.Status.OK).entity(result).type(MediaType.APPLICATION_JSON).build();
    }
    
    @POST
    @Path("/updateBookPrice")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBookPrice(Product p){
        String result = ProductService.updateBookPrice(p.getId(), p.getPrice());
        return Response.status(Response.Status.OK).entity(result).type(MediaType.APPLICATION_JSON).build();
    }
    
    @POST
    @Path("/updateBookStatus")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBookStatus(Product p){
        String result = ProductService.updateBookStatus(p.getId(), p.getStatusId());
        return Response.status(Response.Status.OK).entity(result).type(MediaType.APPLICATION_JSON).build();
    }
    
    @POST
    @Path("/updateBookTitle")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBookTitle(Product p){
        String result = ProductService.updateBookTitle(p.getId(), p.getTitle());
        return Response.status(Response.Status.OK).entity(result).type(MediaType.APPLICATION_JSON).build();
    }
    
    @POST
    @Path("/logDeleteBook")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response logDeleteBook(Product p){
        String result = ProductService.logDeleteBook(p.getId());
        return Response.status(Response.Status.OK).entity(result).type(MediaType.APPLICATION_JSON).build();
    }
    
}
