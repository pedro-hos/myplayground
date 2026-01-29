package org.pedrohos;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class GreetingResourceTest {

    @Test
    void testHelloEndpoint() {

        Exception exception = assertThrows(Exception.class, () -> {
            new GreetingResource().test();
        });

        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(""));
    }

}