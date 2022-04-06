package com.jhost.core.Core.config;

import com.jhost.core.Core.repository.KeyRepository;
import com.jhost.core.Core.service.meta.JWTService;
import com.jhost.core.Core.entity.Key;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.Collection;
import java.util.List;


@Component
public class JWTAuthorizationFilter extends OncePerRequestFilter {

    Logger logger = LoggerFactory.getLogger(JWTAuthorizationFilter.class);

    @Autowired
    private JWTService jwtService;

    @Autowired
    private KeyRepository keysRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            if (tokenExist(request, response)) {
                if (isValidToken(request)) {

                    String username = jwtService.extractUsername(getToken(request));
                    Principal principal = () ->  username;

                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(principal, null, getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                } else {
                    SecurityContextHolder.clearContext();
                }
            } else {
                SecurityContextHolder.clearContext();
            }
            filterChain.doFilter(request, response);
        } catch (IOException | ServletException e) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
        }
    }

    private Boolean isValidToken(HttpServletRequest request) {
        try {
            String key = request.getHeader(Constants.JWTToken.HEADER).replace(Constants.JWTToken.PREFIX, Constants.Strings.EMPTY);
            String username = jwtService.extractUsername(key);
            logger.info("{} token is trying to get authenticated ", username);
            Long userId = Long.parseLong(jwtService.getUserId(key));
            Key keyObj = keysRepository.findByKeyStrAndUserId(key, userId);
            return (keyObj != null);
        } catch (Exception e) {
            return false;
        }
    }

    private String getToken(HttpServletRequest request) {
        return request.getHeader(Constants.JWTToken.HEADER).replace(Constants.JWTToken.PREFIX, "");
    }

    private boolean tokenExist(HttpServletRequest request, HttpServletResponse res) {
        String authenticationHeader = request.getHeader(Constants.JWTToken.HEADER);
        return !(authenticationHeader == null || !authenticationHeader.startsWith(Constants.JWTToken.PREFIX));
    }

    public Collection getAuthorities() {
        return List.of(new SimpleGrantedAuthority(Constants.JWTToken.ROLE));
    }

}
