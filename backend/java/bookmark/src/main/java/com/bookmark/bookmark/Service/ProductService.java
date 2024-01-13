/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookmark.bookmark.Service;

import com.bookmark.bookmark.Modell.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.ArrayList;


/**
 *
 * @author nagya
 */
public class ProductService {
    
    public static String addBook(Integer user_id, String title, String author, Integer price, String description, String image) {
        try {
            if(Product.addBook(user_id, title, author, price, description, image)){
                return "Sikeres könyvfeltöltés";
            }
            else {
                return "Sikertelen könyvfeltöltés";
            }
        }
        catch(Exception ex){
            return ex.getMessage();
        }
    }
    
    public static String deleteBook(Integer id) {
        try {
            if(Product.deleteBook(id)){
                return "Sikeresen kitörölted a könyvet";
            }
            else {
                return "Sikertelen törlés";
            }
        }
        catch(Exception ex){
            return ex.getMessage();
        }
    }
    
    
    public static List<Product> orderBooksAZ() {
        try {
            List<Product> productList = Product.orderBooksAZ();
            return productList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static String orderBooksZA() {
        try {
            if(Product.orderBooksZA()){
                return "Sikeres rendezés";
            }
            else {
                return "Sikertelen rendezés";
            }
        }
        catch(Exception ex){
            return ex.getMessage();
        }
    }
    
    public static List<Product> orderBooksAsc() {
        try {
            List<Product> productList = Product.orderBooksAsc();
            return productList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static List<Product> orderBooksDesc() {
        try {
            List<Product> productList = Product.orderBooksDesc();
            return productList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static List<Product> selectAllBooks() {
        try {
            List<Product> productList = Product.selectAllBooks();
            return productList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }



    
    public static Product selectProduct(Integer id) {
        Product p = Product.selectProduct(id);
            if(p != null){
                return p;
            }
            else {
                return null;
            }
    }
    
    public static String updateBookAuthor(Integer id, String author) {
        try {
            if(Product.updateBookAuthor(id, author)){
                return "Sikeres változtatás";
            }
            else {
                return "Sikertelen változtatás";
            }
        }
        catch(Exception ex){
            return ex.getMessage();
        }
    }
    
    public static String updateBookDesc(Integer id, String description) {
        try {
            if(Product.updateBookDesc(id, description)){
                return "Sikeres változtatás";
            }
            else {
                return "Sikertelen változtatás";
            }
        }
        catch(Exception ex){
            return ex.getMessage();
        }
    }
    
    public static String updateBookImg(Integer id, String newImg) {
        try {
            if(Product.updateBookImg(id, newImg)){
                return "Sikeres változtatás";
            }
            else {
                return "Sikertelen változtatás";
            }
        }
        catch(Exception ex){
            return ex.getMessage();
        }
    }
    
    public static String updateBookPrice(Integer id, Integer price) {
        try {
            if(Product.updateBookPrice(id, price)){
                return "Sikeres változtatás";
            }
            else {
                return "Sikertelen változtatás";
            }
        }
        catch(Exception ex){
            return ex.getMessage();
        }
    }
    
    public static String updateBookStatus(Integer id, Integer newStatus) {
        try {
            if(Product.updateBookStatus(id, newStatus)){
                return "Sikeres változtatás";
            }
            else {
                return "Sikertelen változtatás";
            }
        }
        catch(Exception ex){
            return ex.getMessage();
        }
    }
    
    public static String updateBookTitle(Integer id, String title) {
        try {
            if(Product.updateBookTitle(id, title)){
                return "Sikeres változtatás";
            }
            else {
                return "Sikertelen változtatás";
            }
        }
        catch(Exception ex){
            return ex.getMessage();
        }
    }
    
    public static String logDeleteBook(Integer id) {
        try {
            if(Product.logDeleteBook(id)){
                return "Sikeres logikai törlés";
            }
            else {
                return "Sikertelen logikai törlés";
            }
        }
        catch(Exception ex){
            return ex.getMessage();
        }
    }
    
}
