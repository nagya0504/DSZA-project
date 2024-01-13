/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookmark.bookmark.Service;

import com.bookmark.bookmark.Modell.User;

/**
 *
 * @author nagya
 */
public class UserService {
//    public static String login(String email, String pwd) {
//        try {
//            if(User.login(email, pwd)){
//                
//                return "Sikeres";
//            }
//            else {
//                return "Sikertelen";
//            }
//        }
//        catch(Exception ex){
//            return ex.getMessage();
//        }
//    }
    
    public static String addUser(String username, String familyName, String givenName, String email, String pwd, String phone, String town) {
        try {
            if(User.addUser(username, familyName, givenName, email, pwd, phone, town)){
                return "Sikeres regisztráció";
            }
            else {
                return "Sikertelen regisztráció";
            }
        }
        catch(Exception ex){
            return ex.getMessage();
        }
    }
    
//    public static String addAdmin(String username, String familyName, String givenName, String email, String pwd, String phone, String town) {
//        try {
//            if(User.addAdmin(username, familyName, givenName, email, pwd, phone, town)){
//                return "Sikeres regisztráció";
//            }
//            else {
//                return "Sikertelen regisztráció";
//            }
//        }
//        catch(Exception ex){
//            return ex.getMessage();
//        }
//    }
    
    public static String deleteUser(Integer id) {
        try {
            if(User.deleteUser(id)){
                return "Sikeresen kitörölted a felhasználót.";
            }
            else {
                return "Sikertelen törlés";
            }
        }
        catch(Exception ex){
            return ex.getMessage();
        }
    }
    
//    public static String selectAllUser() {
//        try {
//            if(User.selectAllUser()){
//                return "Sikeres lekérés";
//            }
//            else {
//                return "Sikertelen lekérés";
//            }
//        }
//        catch(Exception ex){
//            return ex.getMessage();
//        }
//    }
    
//    public static String selectAllAdmin() {
//        try {
//            if(User.selectAllAdmin()){
//                return "Sikeres lekérés";
//            }
//            else {
//                return "Sikertelen lekérés";
//            }
//        }
//        catch(Exception ex){
//            return ex.getMessage();
//        }
//    }
    
    public static String updateUserPassword(Integer id, String pwd) {
        try {
            if(User.updateUserPassword(id, pwd)){
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
    
    public static String updateUserPhone(Integer id, String phone) {
        try {
            if(User.updateUserPhone(id, phone)){
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
    
    public static String updateUserTown(Integer id, String town) {
        try {
            if(User.updateUserTown(id, town)){
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
    
    public static String updateUserUsername(Integer id, String username) {
        try {
            if(User.updateUserUsername(id, username)){
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
    
    public static String logDeleteUser(Integer id) {
        try {
            if(User.logDeleteUser(id)){
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
    
//    login:
    public static User selectUserByEmail(String email, String pwd) {
            User u = User.selectUserByEmail(email, pwd);
            if(u != null){
                return u;
            }
            else {
                return null;
            }
    }
}
