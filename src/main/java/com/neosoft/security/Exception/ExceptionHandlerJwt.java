package com.neosoft.security.Exception;

import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerJwt {

    @ExceptionHandler(JwtTokentimeExpiration.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity exception(JwtTokentimeExpiration jwtTokentimeExpiration)
    {
        return new ResponseEntity<>("Jwt token time expired",HttpStatus.FORBIDDEN);
    }




}
