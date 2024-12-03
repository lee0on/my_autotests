package org.example.requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.payloads.Products;

public class ProductApi {

    private static final String apiUrl =
            "http://localhost:8080/api/";

//    private static final String apiUrl =
//            "http://intershop4.skillbox.ru/api/";

    public static Response getProduct(){
        return AuthHelper.login()
                .when()
                .get(apiUrl + "products");
    }

    public static Response getProductId(){
        return AuthHelper.login()
                .when()
                .get(apiUrl + "products/17984");
    }

    public static Response postProduct(Products payload){
        return AuthHelper.login()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(apiUrl + "products");
    }

    public static Response putProduct(Products payload, int id){
        return AuthHelper.login()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .put(apiUrl + "products/" + Integer.toString(id));
    }

    public static Response deleteProduct(int id){
        return AuthHelper.login()
                .when()
                .delete(apiUrl + "products/" + Integer.toString(id));
    }

    public static Response deleteInvalidProduct(){
        return AuthHelper.login()
                .when()
                .delete(apiUrl + "products/1");
    }
}
