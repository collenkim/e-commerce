package com.collenkim.ecommerce.valid;

import com.collenkim.ecommerce.valid.impl.PriceValidator;
import jakarta.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PriceValidator.class)
public @interface PriceValid {

    String message() default "잘못된 금액 입니다.";

    Class[] groups() default {};

    Class[] payload() default {};
    
}
