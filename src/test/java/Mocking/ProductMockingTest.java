package Mocking;

import com.github.tomakehurst.wiremock.WireMockServer;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.restassured.response.Response;
import org.example.requests.ProductApi;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ProductMockingTest {

    private static WireMockServer authMock;

    @BeforeAll
    public static void setAuthMock() {
        authMock = new WireMockServer(options().port(8080));
        authMock.start();
    }

    @AfterAll
    public static void killMock() {
        authMock.stop();
    }

    @Test
    public void getProductsReturns400Response() {
        authMock.stubFor(get(urlEqualTo("/api/products"))
                .willReturn(aResponse().withStatus(400)));

        Response response = ProductApi.getProduct();

        System.out.println(response.getBody());
    }
}