package com.orderbook.platform.book.restapi.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
public class CreateRequest {
    @JsonProperty
    @NotEmpty
    @JsonDeserialize(using = StringDeserializer.class)
    private String isbn;

    @JsonProperty
    @NotEmpty
    @JsonDeserialize(using = StringDeserializer.class)
    private String title;

    @JsonProperty
    @NotEmpty
    @JsonDeserialize(using = StringDeserializer.class)
    private String description;

    @JsonProperty
    @NotNull(message = "published_on is required")
    private Date published_on;

    @JsonProperty
    @NotEmpty
    @JsonDeserialize(using = StringDeserializer.class)
    private String publisher;

    @JsonProperty
    @NotNull(message = "org_price is required")
    private BigDecimal org_price;

    @JsonProperty
    @NotNull
    private List<String> author;
}
