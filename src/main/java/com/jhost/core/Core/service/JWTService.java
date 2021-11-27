package com.jhost.core.Core.service;

import com.jhost.core.Core.constants.CoreConstants;
import com.jhost.core.Core.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Base64;
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
                .claim(CoreConstants.Security.AUTHORITIES, authorities)
                .claim(CoreConstants.Security.NAME, user.getName())
                .setExpiration(new Date(System.currentTimeMillis() + CoreConstants.Security.EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, CoreConstants.Security.AUTHORITIES)
                .compact();
    }

    public Boolean hasTokenExpired(String token) {
        return Jwts.parser()
                .setSigningKey(CoreConstants.Security.SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getExpiration()
                .before(new Date());
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        String username = extractUsername(token);
        return (userDetails.getUsername().equals(username) && !hasTokenExpired(token));

    }

    public String extractUsername(String token) {
        return Jwts.parser()
                .setSigningKey(CoreConstants.Security.SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public String getUserId(String token) {
        return Jwts.parser()
                .setSigningKey(CoreConstants.Security.SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getId();
    }

    public Collection<? extends GrantedAuthority> getAuthorities(String token) {
        Claims claims = Jwts.parser().setSigningKey(CoreConstants.Security.SECRET_KEY).parseClaimsJws(token).getBody();
        return (Collection<? extends GrantedAuthority>) claims.get(CoreConstants.Security.AUTHORITIES);
    }

    public String getName(String token) {
        Claims claims = Jwts.parser().setSigningKey(CoreConstants.Security.SECRET_KEY).parseClaimsJws(token).getBody();
        return (String) claims.get(CoreConstants.Security.NAME);
    }
}
