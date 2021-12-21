package com.orderbook.common.domain;

public interface BusinessRule {
    boolean isBroken();

    String getMessage();
}
