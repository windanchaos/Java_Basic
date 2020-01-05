package main.java;

import io.restassured.RestAssured;
import io.restassured.config.JsonConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.XmlConfig;
import io.restassured.parsing.Parser;
import io.restassured.path.json.config.JsonPathConfig;
import org.junit.jupiter.api.Test;


import java.io.File;
import java.math.BigDecimal;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.*;

//import static io.restassured.matcher.RestAssuredMatchers.*;
/*
官网demo
cd 到此resources目录，使用python的cgi命令启动一个服务进程。
python -m http.server --cgi

http://localhost:8000/lotto.json
http://localhost:8000/products-schema.json

 */
public class AssuredDemo {
    String lottoJson="http://localhost:8000/lotto.json";
    String products_schemaJson="http://localhost:8000/products.json";
    String namespace_xml="http://localhost:8000/namespace-example";
    String shopping_xml="http://localhost:8000/shopping";
    @Test
    public void testJsonSample(){
        given().get(lottoJson).then().statusCode(200).body("lotto.lottoId",equalTo(5));
        given().get(lottoJson).then().body("lotto.winners.winnerId",hasItems(23,54));
        given().get(lottoJson).then().body("price", is(12.12f));
        given().log().all().config(RestAssuredConfig.config().jsonConfig(JsonConfig.jsonConfig()
                .numberReturnType(JsonPathConfig.NumberReturnType.BIG_DECIMAL)))
                .then().body("price", is(new BigDecimal(12.12)));
        given().get(products_schemaJson).then().assertThat().body(matchesJsonSchema(new File("D:\\Code\\Java_Basic\\src\\hogwarts\\interface\\src\\main\\resources\\products-schema.json")));
    }
    @Test
    public void testXMLSample(){
        RestAssured.registerParser("application/octet-stream", Parser.XML);
        given().config(RestAssuredConfig.config().xmlConfig(XmlConfig.xmlConfig().declareNamespace("test","http://localhost/")))
                .when().get(namespace_xml).then().body("foo.bar.text()", equalTo("sudo make me a sandwich!")).log().all().
                body(":foo.:bar.text()", equalTo("sudo ")).
                body("foo.test:bar.text()", equalTo("make me a sandwich!"));
        given().get(shopping_xml).then().body("shopping.category.find.find { it.@type == 'test' }",
                hasItems("Finder"));
    }
}
