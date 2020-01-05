package main.java;
import io.restassured.RestAssured;
import io.restassured.config.JsonConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.XmlConfig;
import io.restassured.parsing.Parser;
import io.restassured.path.json.config.JsonPathConfig;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.jupiter.api.Test;


import java.io.File;
import java.math.BigDecimal;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.*;
/*
企业微信接口实战demo
 */
public class WeworkDemo {
    public static final String getTokenURL="https://qyapi.weixin.qq.com/cgi-bin/gettoken";
    @Test
    public void testGetToken2(){
        given().param("corpid","ww5cbd44b381f7ec39").
                param("corpsecret","DcLg78rHyk5TUthZvAjyLwoFagh_4LZiCtm2jNXgMFY")
                .when().log().all().get(getTokenURL).then()
                .body("errcode",equalTo(0)).log().all();
    }

}
