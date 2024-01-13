package com.bookmark.bookmark.Controller;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    /**
     *
     * @return
     */
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        resources.add(CorsFilter.class);
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.bookmark.bookmark.Controller.CorsFilter.class);
        resources.add(com.bookmark.bookmark.Controller.FavouritesController.class);
        resources.add(com.bookmark.bookmark.Controller.ProductController.class);
        resources.add(com.bookmark.bookmark.Controller.UserController.class);
    }

    
}
