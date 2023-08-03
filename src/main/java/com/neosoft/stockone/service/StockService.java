package com.neosoft.stockone.service;

import com.neosoft.stockone.client.StockoneapiClient;
import com.neosoft.stockone.constant.StockConstant;
import com.neosoft.stockone.model.*;
import com.neosoft.stockone.reader.PropertyReader;
import com.neosoft.stockone.validation.StockValidator;
import org.springframework.beans.factory.annotation.Autowired;
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
        StockResponseDto stockResponseDto = stockoneapiClient.getWarehouses(warehouseName,propertyReader.getAuthorizationToken());
        stockValidator.validateResponseDto(stockResponseDto);
        List<Data> dataList = new ArrayList<>();
        for(String str : stockResponseDto.getData())
        {
           // String str1 = "warehouse:"+str;
           Data data=Data.builder().warehouse(str).build();
            dataList.add(data);
        }
        meta = Meta.builder().code(StockConstant.STOCK).message(StockConstant.DATA_HAVE_BEEN_FETCHED_SUCCESSFULLY).build();
        stockResponse = StockResponse.builder()
                .meta(meta)
                .data(dataList).build();


        return stockResponse;
    }
}
