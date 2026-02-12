package org.example.springsecurity.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service
public class JWTService {
    String secretKey = null;

    public JWTService(){
         try{
             KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
             SecretKey sk = keyGen.generateKey();
             secretKey = Base64.getEncoder().encodeToString(sk.getEncoded());
         }
         catch (NoSuchAlgorithmException e) {
             throw new RuntimeException(e);
         }
    }

    public String generateToken(String username) {
        Map<String,Object> claims = new HashMap<>();
        return Jwts.builder()
                .addClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+60*60*30))
                .signWith(generateKey())
                .compact();
    }


    public Key generateKey(){
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);

    }

    public Claims extractClaims(String token){
        return Jwts.parserBuilder().setSigningKey(generateKey()).build()
                .parseClaimsJws(token).getBody();
    }

    public String extractUserName(String token) {
        return extractClaims(token).getSubject();

    }

    public Date extractExpiryDate(String token){
        return extractClaims(token).getExpiration();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        return extractUserName(token).equals(userDetails.getUsername())
                && extractExpiryDate(token).after(new Date());
    }
}
