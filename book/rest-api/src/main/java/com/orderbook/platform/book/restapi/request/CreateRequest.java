package com.orderbook.platform.book.restapi.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.Date;

@Getter
public class CreateRequest {
    @JsonProperty
    @NotEmpty
    @JsonDeserialize(using = StringDeserializer.class)
    private String title;

    @JsonProperty
    @NotEmpty
    @JsonDeserialize(using = StringDeserializer.class)
    private String description;

    @JsonProperty
    @NotEmpty
    @JsonDeserialize(using = StringDeserializer.class)
    private Date published_on;

    @JsonProperty
    @NotEmpty
    @JsonDeserialize(using = StringDeserializer.class)
    private String publisher;

    @JsonProperty
    @NotEmpty
    @JsonDeserialize(using = StringDeserializer.class)
    private BigDecimal org_price;

    @JsonProperty
    @NotEmpty
    @JsonDeserialize(using = StringDeserializer.class)
    private String author;
}
