package main.java;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseBuilder;
import io.restassured.config.JsonConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.XmlConfig;
import io.restassured.parsing.Parser;
import io.restassured.path.json.config.JsonPathConfig;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.math.BigDecimal;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static io.restassured.path.xml.XmlPath.from;
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
    String store_json="http://localhost:8000/store";
    String base64Stock="http://localhost:8000/base64Stock.json";
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
        given().get(shopping_xml).then().body("shopping.category.find.find{it.@type=='test'}.item",
                hasItems("Coco","Rice"));

    }
    @Test
    public void getData(){
        //设置代理
        RestAssured.proxy("localhost",8888);
        //从响应体中获取对象
        String response=given().get(shopping_xml).asString();
        List<String> groceries = from(response).getList("shopping.category.find { it.@type == 'groceries' }.item");
        System.out.println(groceries.size()+groceries.get(0)+" "+groceries.get(1));
        //深度优先搜索
        //given().get(shopping_xml).then().body("**.find {it.@type=='groceries'}",hasItems("Chocolate", "Coffee"));
        //json 取数据
        RestAssured.registerParser("application/octet-stream", Parser.JSON);
        int abc=given().get(products_schemaJson).then().extract().path("id[1]");
        System.out.println(abc);
        Response rep =given().get(products_schemaJson).then().extract().response();
        System.out.println(rep.headers().toString());
        System.out.println(rep.statusCode());
        System.out.println(rep.asString());

    }
    @Test
    public void testJsonStroe(){
        RestAssured.registerParser("application/octet-stream", Parser.JSON);
        given().get(store_json).then().body("store.book.findAll{it.price < 10}.title",hasItems("Sayings of the Century","Moby Dick"));
        //断言所有author字段值长度总和是否大于50的结果
        given().get(store_json).then().body("store.book.author.collect {it.length()}.sum()",greaterThan(50));
        System.out.println(given().get(store_json).timeIn(TimeUnit.MILLISECONDS));
        System.out.println(given().get(store_json).then().time(lessThan(20L),TimeUnit.MILLISECONDS));
    }

    @Test
    public void testBase64Filter(){
        given()
                .filter((request, response, ctx)->{
                    //next是串改动作
                    Response resOrigin=ctx.next(request,response);
                    //之所以要clone，是因为response中包含了响应头、cookies、contentype、body等信息
                    ResponseBuilder responseBuilder = new ResponseBuilder().clone(resOrigin);
                    String decodeResponse = new String(Base64.getDecoder().decode(resOrigin.body().asString().replace("\n", "")));
                    responseBuilder.setBody(decodeResponse);
                    return responseBuilder.build();
                }).when().get(base64Stock).
                prettyPeek().then().body("SOGO.name",equalTo("搜狗"));
    }
}
