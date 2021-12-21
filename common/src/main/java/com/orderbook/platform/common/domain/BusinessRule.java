package com.orderbook.platform.common.domain;

public interface BusinessRule {
    boolean isBroken();

    String getMessage();
}
