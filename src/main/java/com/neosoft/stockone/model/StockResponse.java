package com.neosoft.stockone.model;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class StockResponse {

    @NotNull
    private Meta meta;

    private List<Data> data;
}
