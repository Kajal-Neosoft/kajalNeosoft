package com.neosoft.singletondemo.controller;

import com.neosoft.singletondemo.service.MyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MyController {

    private final MyService myService;

    @GetMapping("/singleton")
    public String useSingleton()
    {
        myService.doSomethingWithSingleton();
        myService.printSingletonHashcode();
        return "Singleton used";
    }
}
