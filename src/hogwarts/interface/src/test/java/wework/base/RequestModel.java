package wework.base;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import wework.tag.CommonTools;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

/*
发起请求的类对象
 */
@Getter
@Setter
@NoArgsConstructor
public class RequestModel {
    public String method = "get";
    public String url;
    //request连接中的参数
    public HashMap<String, Object> getParams;
    //查询参数
    public HashMap<String, Object> queryParams;
    //请求头
    public HashMap<String, Object> header;
    //post包体
    public HashMap<String, Object> postBody;
    //模版传入的post数据
    //post raw中的模板化了的参数数据
    private HashMap<String, Object> templateParameters;
    // 模版
    public String postTemplateData;


    //核心方法，执行given的动作
    public Response run() {
        CommonTools commonTools = CommonTools.getInstance();
        url = url + "?access_token=" + commonTools.getToken();
        System.out.println(commonTools.getToken().length());
        RequestSpecification request = given();
        //entryset赋值法
        if (null != queryParams) {
            request.params(queryParams);
        }
        if (null != getParams) {
            request.params(getParams);
        }
        //直接赋值
        if (null != header) {
            request.headers(header);
        }
        if (null != postBody) {
            request.contentType(ContentType.JSON);
            request.body(postBody);
        }
        if (null != postTemplateData) {
            request.body(repalce(postTemplateData));
        }
        return request
                .when().log().all().request(method, url)
                .then().log().all().extract().response();
    }

    //post携带
    public Response run(HashMap<String, Object> postBody) {
        this.postBody = postBody;
        return run();
    }

    //post模版
    public Response run(String postTemplateData, HashMap<String, Object> templateParameters) {
        this.postTemplateData = postTemplateData;
        this.templateParameters = templateParameters;
        return run();
    }

    public String repalce(String raw) {
        for (Map.Entry<String, Object> kv : templateParameters.entrySet()) {
            String matcher = "${" + kv.getKey() + "}";
            if (raw.contains(matcher)) {
                System.out.println(kv);
                raw = raw.replace(matcher, kv.getValue().toString());
            }
        }
        return raw;
    }

}
