package com.neosoft.stockone.service;

import com.neosoft.stockone.model.StockResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "StockOneApiClient", url = "https://nxt.stockone.com/api/v1")
public interface StockoneapiClient {


    @GetMapping("/warehouses")
    StockResponseDto getWarehouses(@RequestParam("warehouse") String warehouseName);

}
