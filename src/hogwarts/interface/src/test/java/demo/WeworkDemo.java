package demo;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/*
企业微信接口实战demo
 */
public class WeworkDemo {
    public static final String getTokenURL = "https://qyapi.weixin.qq.com/cgi-bin/gettoken";
    public static String token = given().param("corpid", "ww5cbd44b381f7ec39").
            param("corpsecret", "FDZznCFjLRmxUfw7mXO0i0OQI5_frl3wkPDZIUlwOhg")
            .when().get(getTokenURL).then().extract().path("access_token");
    //创建部门
    String department_create = "https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token=" + token;
    //查询部门列表
    String department_list = "https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token=" + token;
    //删除部门
    String department_delete = "https://qyapi.weixin.qq.com/cgi-bin/department/delete?access_token=" + token;

    //通讯录管理
    @Test
    public void testCreateDepartment() {
        System.out.println(department_list);
        HashMap<String, String> data = new HashMap<>();
        data.put("name", "A接口创建部门");
        data.put("parentid", "2");
        data.put("name_en", "TestCreatDepartment");
        given().contentType(ContentType.JSON).body(data).when().post(department_create).
                then().log().all().statusCode(200)
                .body("errcode", equalTo(0));
    }

    @Test
    public void testDeleteDepartment() {
        // 练习取得id，不是必要的
        Integer id;
        id = given().get(department_list).path("department.find {it.name=='A接口创建部门'}.id");
        //验证删除,不严谨
        if (null != id) {
            given().param("id", id).get(department_delete).then().body("errcode", equalTo(0));
        }
    }

    @Test
    public void testGetDepartment() {

        given().get(department_list).prettyPeek();
    }

}
