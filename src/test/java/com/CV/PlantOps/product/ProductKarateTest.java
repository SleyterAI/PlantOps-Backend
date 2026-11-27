package com.CV.PlantOps.product;

import com.intuit.karate.junit5.Karate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class ProductKarateTest {

    @LocalServerPort
    private int port;

    @Karate.Test
    Karate testProductsApi() {
        System.setProperty("karate.server.port", String.valueOf(port));
        return Karate.run("products").relativeTo(getClass());
    }
}
