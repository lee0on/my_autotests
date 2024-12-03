package org.example.payloads;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductsResponse {

    @JsonProperty
    private int id;
    @JsonProperty
    private Products products;

    public int getId(){
        return id;
    }

    public Products getProducts(){
        return products;
    }

}
