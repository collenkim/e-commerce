package com.collenkim.ecommerce.cd;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProductStatusCd {

    SALE_READY("SALE_READY", "판매대기"),
    SALE("SALE", "판매중"),
    SOLD_OUT("SOLD_OUT", "품절"),
    SALE_STOP("SALE_STOP", "판매중지"),
    ;

    private final String cd;
    private final String name;

}
