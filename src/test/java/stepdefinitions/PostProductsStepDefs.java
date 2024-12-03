package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import org.example.payloads.Products;
import org.example.payloads.categories;
import org.example.payloads.images;
import org.example.requests.ProductApi;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostProductsStepDefs {
    private Products createdProducts;

    @Given("The administrator has a product to add")
    public void the_administrator_has_a_product_to_add(){
        //
    }

    @When("The administrator sends a request to add a product")
    public void the_administrator_sends_a_request_to_add_a_product(){
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
        this.createdProducts =
                response.as(Products.class, ObjectMapperType.JACKSON_2);
    }

    @Then("The server returns a response with correct product data")
    public void the_server_returns_a_response_with_correct_product_data() {
        int stock = createdProducts.getStock_quantity();

        assertEquals(20, stock);
    }
}
