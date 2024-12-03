package org.example.checks;

import io.restassured.response.Response;
import org.example.payloads.Products;
import org.example.payloads.ProductsResponse;
import org.example.payloads.categories;
import org.example.payloads.images;
import org.example.requests.ProductApi;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

    @Test
    public void getProductReturns200(){
        Response response = ProductApi.getProduct();

        assertEquals(200, response.getStatusCode());
    }

    @Test
    public void getProductIdReturns200(){
        Response response = ProductApi.getProductId();

        assertEquals(200, response.getStatusCode());
    }

    @Test
    public void postProductsReturns200(){
        List<images> imagesList = Collections.singletonList(new images(
                "http://intershop4.skillbox.ru/wp-content/uploads/2024/11/033a9e86fd5dee51a132af38d431c632.jpg"));
        List<categories> categoriesList = Collections.singletonList(new categories(
                19,
                "Каталог",
                "Catalog"));

        Products payload = new Products(
                "Test",
                "Teesstt",
                true,
                20,
                "tst",
                1000,
                500,
                500,
                imagesList,
                categoriesList
        );

        Response response = ProductApi.postProduct(payload);
        assertEquals(200, response.getStatusCode());
    }

    @Test
    public void putProductsReturns200(){
        List<images> imagesList = Collections.singletonList(new images(
                "http://intershop4.skillbox.ru/wp-content/uploads/2024/11/033a9e86fd5dee51a132af38d431c632.jpg"));
        List<categories> categoriesList = Collections.singletonList(new categories(
                19,
                "Каталог",
                "Catalog"));

        Products payload = new Products(
                "Test",
                "Teesstt",
                true,
                20,
                "tst",
                1000,
                500,
                500,
                imagesList,
                categoriesList
        );

        Response response = ProductApi.postProduct(payload);
        ProductsResponse createdProductsResponse =
                response.as(ProductsResponse.class);
        Response putResponse = ProductApi.putProduct(
             payload,
             createdProductsResponse.getId()
        );
        assertEquals(200, putResponse.getStatusCode());
    }

    @Test
    public void deleteProductsReturns200(){
        List<images> imagesList = Collections.singletonList(new images(
                "http://intershop4.skillbox.ru/wp-content/uploads/2024/11/033a9e86fd5dee51a132af38d431c632.jpg"));
        List<categories> categoriesList = Collections.singletonList(new categories(
                19,
                "Каталог",
                "Catalog"));

        Products payload = new Products(
                "Test",
                "Teesstt",
                true,
                20,
                "tst",
                1000,
                500,
                500,
                imagesList,
                categoriesList
        );

        Response response = ProductApi.postProduct(payload);
        ProductsResponse createdProductsResponse =
                response.as(ProductsResponse.class);
        Response deleteResponse = ProductApi.deleteProduct(
                createdProductsResponse.getId()
        );
        assertEquals(200, deleteResponse.getStatusCode());
    }

    @Test
    public void deleteInvalidProduct(){
        Response response = ProductApi.deleteInvalidProduct();

        assertEquals(200, response.getStatusCode());
        assertEquals("{\"code\":\"woocommerce_rest_product_invalid_id\",\"message\":\"Invalid ID.\",\"data\":{\"status\":404}}", response.getBody().asString());
    }
}
