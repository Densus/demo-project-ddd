package com.orderbook.platform.order.restapi.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
public class RequestOrder {
    @JsonProperty
    @NotNull
    private Long bookId;

    @JsonProperty
    @NotEmpty
    @JsonDeserialize(using = StringDeserializer.class)
    private String customerName;

    @JsonProperty
    @NotNull
    private Date expectedDeliveryDate;

    @JsonProperty
    @NotNull
    private Integer numBook;

//    @JsonProperty
//    @NotNull(message = "org_price is required")
//    private BigDecimal bookPrice;
}
