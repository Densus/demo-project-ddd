package com.orderbook.platform.common.domain;

public interface Entity {
    default void checkRule(BusinessRule rule) throws BusinessRuleValidationException {
        if(rule.isBroken()) {
            throw new BusinessRuleValidationException(rule);
        }
    }
}
