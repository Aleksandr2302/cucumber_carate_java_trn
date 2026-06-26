package karate;

import com.intuit.karate.core.MockServer;
import com.intuit.karate.junit5.Karate;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class KarateTest {

    static MockServer server;

    @BeforeAll
    static void beforeAll() {
        server = MockServer.feature("classpath:karate/mock/payment-mock.feature")
                .http(8080)
                .build();
    }

    @AfterAll
    static void afterAll() {
        server.stop();
    }

    @Karate.Test
    Karate testAll() {
        return Karate.run("classpath:karate/api").relativeTo(getClass());
    }
}