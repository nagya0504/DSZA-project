/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookmart.bookmark.util;

import com.bookmark.bookmark.Modell.User;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.TextCodec;
import io.jsonwebtoken.security.Keys;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import java.util.Date;

import static java.util.Base64.*;

/**
 *
 * @author nagya
 */
public class Token {
    
    public static String createToken(User u) {
    Instant now = Instant.now();
        int id = u.getId();
        
//        String role;
////        if (u.isSuperadmin()) {
//        role = "superadmin";
            
//        } else {
//            role = "user";
//        }
        String token = Jwts.builder()
                .setIssuer("bookmark")
                .setSubject("management")
                .claim("id", id)
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(7, ChronoUnit.DAYS)))
                .signWith(
                        SignatureAlgorithm.HS256,
                        TextCodec.BASE64.decode("c3p1cGVyVGl0a29zTW9uZGF0QVRva2VuaGV6")
                )
                .compact();

        return token;
    }

    public static int decodeJwt(String token) {
        try {
            byte[] secret = getDecoder().decode("Yn2kjibddFAWtnPJ2AFlL8WXmohJMCvigQggaEypa5E=");
            Jws<Claims> result;
            result = Jwts.parser().setSigningKey(Keys.hmacShaKeyFor(secret)).parseClaimsJws(token);
            int id = result.getBody().get("id", Integer.class);
            boolean sa = result.getBody().get("scope", String.class).equals("superadmin");
            
            System.out.println(id + " " + sa);
                return 1;

        } catch (Exception ex) {
            System.err.println("Hiba: " + ex.getMessage());
            //A token lejárt
            return 2;
        }

    }

}
