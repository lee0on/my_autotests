package org.example;


import au.com.dius.pact.provider.junit5.HttpTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
import au.com.dius.pact.provider.junitsupport.Provider;
import au.com.dius.pact.provider.junitsupport.loader.PactBroker;
import au.com.dius.pact.provider.junitsupport.loader.PactBrokerAuth;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;

@Provider("Backend provider")
@PactBroker(url = "https://kekint.pactflow.io", authentication = @PactBrokerAuth(token = "aStODj8Ou9HwEPAEjcTepw"))
public class ProductVerifyTest {

    @BeforeEach
    void before(PactVerificationContext context) {
        System.setProperty("pact.verifier.publishResults", "true");

        context.setTarget(new HttpTestTarget("intershop4.skillbox.ru", 80, "/api"));
    }

    @TestTemplate
    @ExtendWith(PactVerificationInvocationContextProvider.class)
    void pactVerificationTestTemplate(PactVerificationContext context) {
        context.verifyInteraction();
    }
}
