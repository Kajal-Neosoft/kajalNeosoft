package com.neosoft.singletondemo.service;

import com.neosoft.singletondemo.entity.MySingleton;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyService {

    private final MySingleton mySingleton;

    public void doSomethingWithSingleton(){
        mySingleton.doSomething();

    }

    public void printSingletonHashcode(){
        mySingleton.printHashCode();

    }


}
