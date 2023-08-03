package com.neosoft.stockone.reader;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class PropertyReader {

    @Value("${authorization.token}")
    private String authorizationToken;

}
