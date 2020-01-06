package main.java.department;

import static io.restassured.RestAssured.given;

/*工具类
提供token
api的url等
单例模式
 */
public class DepartmentTools {
    public static final String getTokenURL="https://qyapi.weixin.qq.com/cgi-bin/gettoken";
    public static String token=given().param("corpid","ww5cbd44b381f7ec39").
            param("corpsecret","FDZznCFjLRmxUfw7mXO0i0OQI5_frl3wkPDZIUlwOhg")
            .when().get(getTokenURL).then().extract().path("access_token");


    //单例模式，私有化默认构造函数，则不会实例化
    private static DepartmentTools departmentTools = new DepartmentTools();
    private DepartmentTools(){}
    public static DepartmentTools getInstance(){
        return departmentTools;
    }

    //取token
    private String getToken(){
       return given().param("corpid","ww5cbd44b381f7ec39").
                param("corpsecret","FDZznCFjLRmxUfw7mXO0i0OQI5_frl3wkPDZIUlwOhg")
                .when().get(getTokenURL).then().extract().path("access_token");
    }
    //取api

}
