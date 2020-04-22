package tools;

import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

/*
工具类
提供token
api的url等
单例模式
 */
public class CommonTools {
    public static final String getTokenURL = "https://qyapi.weixin.qq.com/cgi-bin/gettoken";
    public static String token = getToken();

    //单例模式，私有化默认构造函数，则不会实例化
    private static CommonTools departmentTools = new CommonTools();

    private CommonTools() {
    }

    public static CommonTools getInstance() {
        return departmentTools;
    }

    //取token
    public static String getToken() {
        return given().param("corpid", "ww5cbd44b381f7ec39").
                param("corpsecret", "FDZznCFjLRmxUfw7mXO0i0OQI5_frl3wkPDZIUlwOhg")
                .when().get(getTokenURL).then().extract().path("access_token");
    }

    /*
    部门管理部分
     */
    //创建部门
    private String departmentCreateURL = "https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token=" + token;
    //查询部门列表
    private String departmentListURL = "https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token=" + token;
    //删除部门
    private String departmentDeleteURL = "https://qyapi.weixin.qq.com/cgi-bin/department/delete?access_token=" + token;
    //更新部门
    private String departmentUpdateURL = "https://qyapi.weixin.qq.com/cgi-bin/department/update?access_token=" + token;


    /*
    标签管理部分
     */
    private String tagCreateURL = "https://qyapi.weixin.qq.com/cgi-bin/tag/create?access_token=" + token;
    private String tagUpdateURL = "https://qyapi.weixin.qq.com/cgi-bin/tag/update?access_token=" + token;
    //delete
    private String tagDeleteURL = "https://qyapi.weixin.qq.com/cgi-bin/tag/delete?access_token=" + token;
    //get
    private String tagGetUserURL = "https://qyapi.weixin.qq.com/cgi-bin/tag/get?access_token=" + token;
    //增加标签成员
    private String tagAddtagusersURL = "https://qyapi.weixin.qq.com/cgi-bin/tag/addtagusers?access_token=" + token;
    //删除标签成员
    private String tagDeltagusersURL = "https://qyapi.weixin.qq.com/cgi-bin/tag/deltagusers?access_token=" + token;
    //获取标签列表
    private String tagListURL = "https://qyapi.weixin.qq.com/cgi-bin/tag/list?access_token=" + token;


    public String getDepartmentCreateURL() {
        return departmentCreateURL;
    }

    public String getDepartmentListURL() {
        return departmentListURL;
    }

    public String getDepartmentDeleteURL() {
        return departmentDeleteURL;
    }

    public String getDepartmentUpdateURL() {
        return departmentUpdateURL;
    }

    public String getTagCreateURL() {
        return tagCreateURL;
    }

    public String getTagUpdateURL() {
        return tagUpdateURL;
    }

    public String getTagDeleteURL() {
        return tagDeleteURL;
    }

    public String getTagUserURL() {
        return tagGetUserURL;
    }

    public String getTagAddtagusersURL() {
        return tagAddtagusersURL;
    }

    public String getTagDeltagusersURL() {
        return tagDeltagusersURL;
    }

    public String getTagListURL() {
        return tagListURL;
    }

}
