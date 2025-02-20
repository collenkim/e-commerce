package com.collenkim.ecommerce.cd;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PriceTypeCd {

    REGULAR("REGULAR", "정상가"),
    DISCOUNT("DISCOUNT", "할인"),
    ;

    private final String cd;
    private final String name;
}
