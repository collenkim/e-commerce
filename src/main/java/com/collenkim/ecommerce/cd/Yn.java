package com.collenkim.ecommerce.cd;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Yn {

    Y("Y"),
    N("N"),
    ;

    private String code;

}
