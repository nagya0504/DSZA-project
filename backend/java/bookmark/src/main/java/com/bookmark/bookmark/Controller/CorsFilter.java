package com.bookmark.bookmark.Controller;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class CorsFilter implements ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
        // Set the Access-Control-Allow-Origin header to allow requests from your development domain
        responseContext.getHeaders().add("Access-Control-Allow-Origin", "http://127.0.0.1:5500");

        // You might also need to set other CORS headers like methods and headers
        responseContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        responseContext.getHeaders().add("Access-Control-Allow-Headers", "Content-Type, Accept");
        responseContext.getHeaders().add("Access-Control-Allow-Credentials", "true");

        // Set the max age for the preflight request in seconds
        responseContext.getHeaders().add("Access-Control-Max-Age", "86400");

        // If it's a preflight request, complete it with a 200 OK response
        if (requestContext.getMethod().equals("OPTIONS")) {
            responseContext.setStatus(200);
        }
    }
}
