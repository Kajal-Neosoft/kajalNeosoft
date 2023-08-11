package com.neosoft.security.Exception;


public class JwtTokentimeExpiration extends RuntimeException{

    public JwtTokentimeExpiration(String message)
    {
        super(message);
    }

}
