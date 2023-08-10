package com.neosoft.security.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    // 77397A24432646294A404E635266556A586E327235753878214125442A472D4B
    // go to the all key genereator website and generate custom key generator minimum required bit is 256bit
    public static final String SECRET_KEY="5368566D597133743677397A244326452948404D635166546A576E5A72347537";
    public String extractUsername(String token)
    {
        return extractClaims(token,Claims::getSubject); // in subject will exctract email as a userName our email wil be extract
    }

    // if u want to generate token for userdetails only not for extra claims
    public String generateToken(UserDetails userDetails)
    {
        return generateToken(new HashMap<>(),userDetails);
    }

    // method to generate token
    public String generateToken(
            Map<String,Object> extraClaims,
            UserDetails userDetails
    )
    {
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // method to validate token
    public boolean isTokenValid(String token, UserDetails userDetails)
    {
        final String username=extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaims(token,Claims::getExpiration);
    }

    //we are creating this method to extract single claims which will pass
    public <T> T extractClaims(String token, Function<Claims,T> claimsResolver)
    {
        final Claims claims=extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String token)
    {
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey()) // to generate token we want key
                .build()
                .parseClaimsJws(token) //to encode claims or convert the claims
                .getBody();
    }

    private Key getSignInKey() {
       byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY); // to decode the secret key by using base64 algorithm
        return Keys.hmacShaKeyFor(keyBytes); // using this algorithm
    }
}
