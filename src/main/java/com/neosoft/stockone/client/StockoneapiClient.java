package com.neosoft.stockone.client;

import com.neosoft.stockone.model.StockResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "StockOneApiClient", url = "${stockone.warehouse.service.url}")
public interface StockoneapiClient {


    @GetMapping("/warehouses")
    StockResponseDto getWarehouses(@RequestParam("warehouse") String warehouseName, @RequestHeader("Authorization") String authorizationToken);

}
