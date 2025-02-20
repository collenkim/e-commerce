package com.collenkim.ecommerce.cd;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OptionTypeCd {

    SIZE("SIZE", "사이즈"),
    COLOR("COLOR", "색상"),
    ;

    private final String cd;
    private final String name;
}
