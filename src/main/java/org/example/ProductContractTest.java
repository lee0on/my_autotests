package org.example;

import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import io.restassured.response.Response;
import org.example.requests.ProductApi;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Map;

@ExtendWith(PactConsumerTestExt.class)
@PactTestFor(providerName = "Backend provider", port = "8080")
public class ProductContractTest {

    @Pact(consumer = "Frontend consumer", provider = "Backend provider")
    public RequestResponsePact createPact(PactDslWithProvider builder){
        return builder
                .uponReceiving("Delete invalid product")
                .path("/api/products/1")
                .method("DELETE")
                .body("")
                .headers(Map.of("Accept", "*/*", "Connection", "Keep-Alive", "Accept-Encoding", "gzip, deflate", "User-agent", "Apache-HttpClient/4.5.3 (Java/22.0.2)", "Host", "localhost:8080"))
                .willRespondWith()
                .status(200)
                .headers(Map.of("Content-Type", "text/plain"))
                .body("{\"code\":\"woocommerce_rest_product_invalid_id\",\"message\":\"Invalid ID.\",\"data\":{\"status\":404}}", "text/plain")
                .toPact();
    }

    @Test
    public void deleteInvalidProduct(){
        Response response = ProductApi.deleteInvalidProduct();
    }
}
