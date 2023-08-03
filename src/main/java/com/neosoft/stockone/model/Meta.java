package com.neosoft.stockone.model;

import lombok.*;

import javax.validation.constraints.NotNull;


@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
public class Meta {

    @NotNull
    private String code;

    @NotNull
    private String message;

}
