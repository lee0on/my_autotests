package org.example.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;

public class images {

    @JsonProperty
    private String src;

    public images() {}

    public images(String src){
        this.src = src;
    }

    public String getSrc(){
        return src;
    }
}
