package com.neo.v1.controller;

import com.neo.core.model.ApiError;
import com.neo.v1.cas.api.NeoServiceV1Api;
import com.neo.v1.cas.model.CasResponse;

import com.neo.v1.service.CasService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api
@Slf4j
@RestController
@RequestMapping("/api/v1/cas")
@Validated
@AllArgsConstructor
@ApiResponses({
        @ApiResponse(code = 400, message = "BadRequest", response = ApiError.class),
        @ApiResponse(code = 403, message = "Forbidden", response = ApiError.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = ApiError.class)
})
public class CasController implements NeoServiceV1Api {


    private final CasService casService;

    @GetMapping("/configurations")
    @Override
    public ResponseEntity<CasResponse> getCasConfigurations(String segment, String filterByParameter, String unitName) {
      return ResponseEntity.ok(casService.getConfiguration(segment,filterByParameter,unitName));
    }


}
