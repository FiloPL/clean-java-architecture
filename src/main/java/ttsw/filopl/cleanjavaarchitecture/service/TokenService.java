package ttsw.filopl.cleanjavaarchitecture.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ttsw.filopl.cleanjavaarchitecture.configuration.JwtConfigurationProperties;

import java.security.Key;
import java.util.Date;
import java.util.Map;

/**
 * Created by T. Filo Zegarlicki on 28.07.2022
 **/

@Service
public class TokenService {

    private final JwtConfigurationProperties properties;

    public TokenService(JwtConfigurationProperties properties) {
        this.properties = properties;
    }

    public String getUsernameFromToken(String token) {
        return getAllClaimsFromToken(token).getSubject();
    }

    public String generateNewToken(UserDetails userDetails) {
        Map<String, Object> claims = Map.of(); // e.g. roles
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + properties.getValidity() * 1000))
                .signWith(key(), SignatureAlgorithm.HS512)
                .compact();
    }

    public boolean isValidForUser(String token, UserDetails userDetails) {
        String username = getUsernameFromToken(token);
        return !isTokenExpired(token) && username.equals(userDetails.getUsername());
    }

    private Boolean isTokenExpired(String token) {
        return getAllClaimsFromToken(token)
                .getExpiration()
                .before(new Date());
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key key() {
        return Keys.hmacShaKeyFor(properties.getSecret().getBytes());
    }
}
