package com.neo;

import com.neo.config.SwaggerConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;

@SpringBootApplication
@EnableScheduling
@EnableFeignClients
@Import(value = {SwaggerConfig.class, BeanValidatorPluginsConfiguration.class})
public class Application {

    private static final String SPRING_PROPERTY_CONFIG = "spring.config.name=application";

    public static void main(String[] args) {
        new SpringApplicationBuilder().sources(Application.class).properties(SPRING_PROPERTY_CONFIG).run(args);
    }
}