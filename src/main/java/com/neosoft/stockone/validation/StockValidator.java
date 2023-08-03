package com.neosoft.stockone.validation;

import com.neosoft.stockone.constant.StockConstant;
import com.neosoft.stockone.exception.NotFoundException;
import com.neosoft.stockone.exception.WarehouseNameException;
import com.neosoft.stockone.model.StockResponseDto;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class StockValidator {

    public void validateStockwarehouseName(String warehouseName)
    {
        if(warehouseName.isEmpty() || warehouseName == null)
        {
            throw new WarehouseNameException(StockConstant.WAREHOUSENAME_NOT_FOUND);
        }
    }

    public void validateResponseDto(StockResponseDto stockResponseDto)
    {
        if(Objects.isNull(stockResponseDto) || stockResponseDto.getData().isEmpty())
        {
            throw new NotFoundException(StockConstant.STOCK_NOT_FOUND_EXCEPTION);
        }
    }





}
