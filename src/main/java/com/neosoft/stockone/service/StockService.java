package com.neosoft.stockone.service;

import com.neosoft.stockone.constant.StockConstant;
import com.neosoft.stockone.model.*;
import com.neosoft.stockone.reader.PropertyReader;
import com.neosoft.stockone.validation.StockValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockoneapiClient stockoneapiClient;

    @Autowired
    private PropertyReader propertyReader;

    @Autowired
    private StockValidator stockValidator;
    //

    public StockResponse getWarehouse(String warehouseName,String authorizationToken)
    {
        StockResponse stockResponse=null;
        Meta meta=null;
        stockValidator.validateStockwarehouseName(warehouseName);
        StockResponseDto stockResponseDto = stockoneapiClient.getWarehouses(warehouseName);
        stockValidator.validateResponseDto(stockResponseDto);
        List<Warehouse> warehouseList = new ArrayList<>();
        for(String str : stockResponseDto.getData())
        {
           // String str1 = "warehouse:"+str;
            Warehouse warehouse=Warehouse.builder().warehouse(str).build();
            warehouseList.add(warehouse);
        }
        meta = Meta.builder().code(StockConstant.STOCK).message(StockConstant.DATA_HAVE_BEEN_FETCHED_SUCCESSFULLY).build();
        stockResponse = StockResponse.builder()
                .meta(meta)
                .data(Data.builder().warehouse(warehouseList).build()).build();

        return stockResponse;
    }
}
