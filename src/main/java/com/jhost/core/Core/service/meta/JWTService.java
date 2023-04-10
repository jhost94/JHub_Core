package com.jhost.core.Core.service.meta;

import com.jhost.core.Core.constants.Security;
import com.jhost.core.Core.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;

@Service
public class JWTService {

    public String createToken(User user, UserDetails userDetails) {
        String username = userDetails.getUsername();

        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        return Jwts.builder()
                .setSubject(username)
                .setId(user.getId().toString())
                .claim(Security.AUTHORITIES, authorities)
                .claim(Security.NAME, user.getName())
                .setExpiration(new Date(System.currentTimeMillis() + Security.EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, Security.AUTHORITIES)
                .compact();
    }

    public Boolean hasTokenExpired(String token) {
        return getJWTClaims(token)
                .getExpiration()
                .before(new Date());
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        String username = extractUsername(token);
        return (userDetails.getUsername().equals(username) && !hasTokenExpired(token));

    }

    public String extractUsername(String token) {
        return getJWTClaims(token).getSubject();
    }

    public String getUserId(String token) {
        return Jwts.parser()
                .setSigningKey(Security.SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getId();
    }

    public Collection<? extends GrantedAuthority> getAuthorities(String token) {
        Claims claims = getJWTClaims(token);
        return (Collection<? extends GrantedAuthority>) claims.get(Security.AUTHORITIES);
    }

    public String getName(String token) {
        Claims claims = getJWTClaims(token);
        return (String) claims.get(Security.NAME);
    }

    private Claims getJWTClaims(String token) {
        return Jwts.parser()
                .setSigningKey(Security.SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}
