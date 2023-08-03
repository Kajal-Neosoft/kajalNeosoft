package com.neosoft.stockone.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class StockResponse {

    @NotNull
    private Meta meta;

    private Data data;
}
