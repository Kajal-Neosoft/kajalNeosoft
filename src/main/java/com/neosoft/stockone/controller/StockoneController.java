package com.neosoft.stockone.controller;

import com.neosoft.stockone.model.StockResponse;
import com.neosoft.stockone.reader.PropertyReader;
import com.neosoft.stockone.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stockone")
public class StockoneController {

    @Autowired
    private StockService stockService;

    @Autowired
    private PropertyReader propertyReader;

    @GetMapping("/getWarehouse")
    public ResponseEntity<StockResponse> getWarehouse(@RequestParam(required = true) String warehouseName)
    {
        return ResponseEntity.ok(stockService.getWarehouse(warehouseName,propertyReader.getAuthorizationToken()));
    }
}
