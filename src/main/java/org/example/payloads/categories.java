package org.example.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;

public class categories {

    @JsonProperty
    private int id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String slug;

    public categories() {}

    public categories(int id, String name, String slug){
        this.id = id;
        this.name = name;
        this.slug = slug;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getSlug(){
        return slug;
    }
}
