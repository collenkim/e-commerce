package com.collenkim.ecommerce.valid.impl;

import com.collenkim.ecommerce.valid.PriceValid;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

public class PriceValidator implements ConstraintValidator<PriceValid, BigDecimal> {

    @Override
    public boolean isValid(BigDecimal value, ConstraintValidatorContext context) {
        return false;
    }

}
