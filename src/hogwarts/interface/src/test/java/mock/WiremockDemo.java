package mock;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class WiremockDemo {
    static WireMockServer wireMockServer = new WireMockServer(wireMockConfig().port(8089)); //No-args constructor will start on port 8080, no HTTPS

    @BeforeAll
    static void beforeAll() {
        wireMockServer.start();
    }

    @Test
    void testStub() {
        stubFor(get(urlEqualTo("/stub"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "text/plain")
                        .withBody("Hello world! stub")));

        given().when().log().all().get("localhost:8089/stub").then()
                .body("Hello world! stub", equalTo("Hello world! stub"));
    }

    @AfterAll
    static void afterAll() {
        wireMockServer.stop();
    }
}


