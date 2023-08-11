package com.neosoft.security.controller;

import com.neosoft.security.user.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo-controller")
public class DemoController {

    @GetMapping
    public ResponseEntity<BaseResponse> sayHello()
    {
        return ResponseEntity.ok(BaseResponse.builder().message("hello from secured endpoint").code("200").build());
    }
}
