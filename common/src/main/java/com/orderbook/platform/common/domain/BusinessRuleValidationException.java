package com.orderbook.platform.common.domain;

public class BusinessRuleValidationException extends Exception{
    private static final long serialVersionUID = -7560159790047077694L;

    private final BusinessRule brokenRule;

    public BusinessRuleValidationException(BusinessRule rule) {
        super(rule.getMessage());
        this.brokenRule = rule;
    }

    public BusinessRule getBrokenRule() {
        return brokenRule;
    }
}
