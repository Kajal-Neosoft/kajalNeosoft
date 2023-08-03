package com.neosoft.stockone.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Meta {

    @NotNull
    private String code;

    @NotNull
    private String message;

}
