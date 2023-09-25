package com.neosoft.singletondemo.config;

import com.neosoft.singletondemo.entity.MySingleton;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SingletonConfig {

    @Bean
    public MySingleton mySingleton()
    {
        return MySingleton.getInstance();
    }
}
