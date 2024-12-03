package org.example.payloads;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Products {

    @JsonProperty
    private String name;
    @JsonProperty
    private String slug;
    @JsonProperty
    private boolean manage_stock;
    @JsonProperty
    private int stock_quantity;
    @JsonProperty
    private String description;
    @JsonProperty
    private int price;
    @JsonProperty
    private int regular_price;
    @JsonProperty
    private int sale_price;
    @JsonProperty
    private List<images> images;
    @JsonProperty
    private List<categories> categories;

    public Products() {}

    public Products(String name, String slug, boolean manage_stock, int stock_quantity, String description, int price, int regular_price, int sale_price, List<images> images, List<categories> categories){
        this.name = name;
        this.slug = slug;
        this.manage_stock = manage_stock;
        this.stock_quantity = stock_quantity;
        this.description = description;
        this.price = price;
        this.regular_price = regular_price;
        this.sale_price = sale_price;
        this.images = images;
        this.categories = categories;
    }

    public String getName(){
        return name;
    }

    public String getSlug(){
        return slug;
    }

    public boolean isManage_stock(){
        return manage_stock;
    }

    public int getStock_quantity(){
        return stock_quantity;
    }

    public String getDescription(){
        return description;
    }

    public int getPrice() {
        return price;
    }

    public int getRegular_price() {
        return regular_price;
    }

    public int getSale_price() {
        return sale_price;
    }

    public List<org.example.payloads.images> getImages() {
        return images;
    }

    public List<org.example.payloads.categories> getCategories() {
        return categories;
    }
}