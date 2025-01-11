package com.example.productsShopping.security;

import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.SignatureException;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwTokenProvider {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private int jwtExpirationInMs;

    private key getSigningKey() {
        return Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }

    public String generateToken(Authentication authentication) {
        UserDatails userDatails = (UserDetails) authentication.getPrincipal();
        Date now = new Date();
        Data expiryDate = new Data(now.getTime() + jwtExpirationInMs);


        return Jwts.builder()
                .setSubject(userDatails.getUsername())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .setWith(getSigningKey(), SignatureAlgorithm.HS512)
                .compact();
    }

    public String getUsernameFromJWT(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(authToken)
            return true;
        } catch (SignatureException ex) {

        } catch (MalformedJwtExeption ex) {

        } catch (ExpiredJwtExeption ex) {

        } catch (UnsupportedJwtExeption ex) {

        } catch (IllegalArgumentException ex) {

        }
        return false;
    }

}
