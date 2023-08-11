package com.neosoft.security.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final HandlerExceptionResolver exceptionResolver;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private  UserDetailsService userDetailsService;

    public JwtAuthenticationFilter(HandlerExceptionResolver handlerExceptionResolver)
    {
        this.exceptionResolver=handlerExceptionResolver;

    }

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain)
            throws ServletException, IOException {

        //key should be not changed aise hi rahega bcz postman me key vaise hi paas kiya gya hai
        final String authHeader=request.getHeader("Authorization");
        final String jwt;
        final String userEmail;

        if(authHeader==null || !authHeader.startsWith("Bearer "))
        {
            //next filter lagega ager header null rahega to and bearer se start nhi raheg
            filterChain.doFilter(request,response);
            return;
        }

        jwt=authHeader.substring(7);

        //todo extract username from jwt token

        userEmail=jwtService.extractUsername(jwt);
        //if user is not null and not authenticated
        if(userEmail != null && SecurityContextHolder.getContext().getAuthentication()==null)
        {
            UserDetails userDetails=this.userDetailsService.loadUserByUsername(userEmail);
            //check if the token is valid or not
            try {
                if(jwtService.isTokenValid(jwt,userDetails))
                {
                    UsernamePasswordAuthenticationToken authToken=new UsernamePasswordAuthenticationToken(
                            userDetails,null,userDetails.getAuthorities()
                    );
                    //udating the filter
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            }
        catch(Exception ex){
             throw ex;
        }
        }
        filterChain.doFilter(request,response);
    }
}
