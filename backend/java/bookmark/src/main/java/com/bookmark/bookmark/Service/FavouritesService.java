/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookmark.bookmark.Service;

import com.bookmark.bookmark.Modell.Favourites;
import java.util.List;

/**
 *
 * @author nagya
 */
public class FavouritesService {
    
    public static String addFav(Integer userId, Integer productId) {
        try {
            if(Favourites.addFav(userId, productId)){
                return "Sikeresen felvetted a kedvencekbe";
            }
            else {
                return "Sikertelen felvétel";
            }
        }
        catch(Exception ex){
            return ex.getMessage();
        }
    }
    
    public static String deleteFav(Integer userId, Integer bookId) {
        try {
            if(Favourites.deleteFav(userId, bookId)){
                return "Sikeresen kitörölted a könyvet a kedvencekből.";
            }
            else {
                return "Sikertelen törlés";
            }
        }
        catch(Exception ex){
            return ex.getMessage();
        }
    }
    
    public static List<Favourites> selectAllFav(Integer userId) {
        try {
            List<Favourites> favList = Favourites.selectAllFav(userId);
            return favList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
