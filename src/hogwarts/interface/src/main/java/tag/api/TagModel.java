package main.java.tag.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import main.java.CommonTools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class TagModel {
    private String tagname;
    private Integer tagid;
    private CommonTools commonTools=CommonTools.getInstance();

    /*
    创建标签
    参数说明：

    参数	必须	说明
    access_token	是	调用接口凭证
    tagname	是	标签名称，长度限制为32个字以内（汉字或英文字母），标签名不可与其他标签重名。
    tagid	否	标签id，非负整型，指定此参数时新增的标签会生成对应的标签id，不指定时则以目前最大的id自增。
     */
    public Response create(String tagname,Integer ... values){
        String creatURL=commonTools.getTagCreateURL();
        HashMap<String,Object> data=new HashMap<>();
        data.put("tagname",tagname);
        //tagid传值就带入
        if(values.length==1){
            data.put("tagid",values[0]);
        }
        return given().contentType(ContentType.JSON).body(data)
                .post(creatURL).then()
                .extract().response();
    }

    /*
    更新标签名字
    参数说明：

    参数	必须	说明
    access_token	是	调用接口凭证
    tagid	是	标签ID
    tagname	是	标签名称，长度限制为32个字（汉字或英文字母），标签不可与其他标签重名。
     */
    public Response update(Integer tagid,String tagname){
        String upateURL=commonTools.getTagUpdateURL();
        HashMap<String,Object> data=new HashMap<>();
        data.put("tagname",tagname);
        data.put("tagid",tagid);
        return given().contentType(ContentType.JSON).body(data)
                .post(upateURL).then()
                .extract().response();
    }

    /*
    删除标签
    参数说明：

    参数	必须	说明
    access_token	是	调用接口凭证
    tagid	是	标签ID
     */
    public Response delete(Integer tagid){
        String deleteURL=commonTools.getTagDeleteURL();
        return given().param("tagid",tagid)
                .get(deleteURL).then()
                .extract().response();
    }

    /*
    获取标签成员
    参数说明：

    参数	必须	说明
    access_token	是	调用接口凭证
    tagid	是	标签ID
     */
    public Response getUserList(Integer tagid){
        String tagUserURL=commonTools.getTagUserURL();
        return given().param("tagid",tagid)
                .get(tagUserURL).then()
                .extract().response();
    }
    /*
    增加标签成员
    参数说明：

    参数	必须	说明
    access_token	是	调用接口凭证
    tagid	是	标签ID
    userlist	否	企业成员ID列表，注意：userlist、partylist不能同时为空，单次请求长度不超过1000
    partylist	否	企业部门ID列表，注意：userlist、partylist不能同时为空，单次请求长度不超过100
     */
    public Response addtagusers(Integer tagid, List ... values){
        String tagAddtagusersURL=commonTools.getTagAddtagusersURL();
        return tagUserCommon(tagAddtagusersURL,values);
    }
    /*
    由于不能同时为空，所以单独操作一个方法。来独立测试仅应该参数时的情况
    listname:
        userlist 或 partylist

     */
    public Response addtagusers(Integer tagid, String listname,ArrayList list){
        String tagAddtagusersURL=commonTools.getTagAddtagusersURL();
        HashMap<String,Object> data = new HashMap<>();
        data.put("tagid",tagid);
        data.put(listname,list);
        return given().contentType(ContentType.JSON).body(data)
                .when().post(tagAddtagusersURL).then().extract().response();
    }
    /*
    删除标签成员参数说明：

    参数	必须	说明
    access_token	是	调用接口凭证
    tagid	是	标签ID
    userlist	否	企业成员ID列表，注意：userlist、partylist不能同时为空，单次请求长度不超过1000
    partylist	否	企业部门ID列表，注意：userlist、partylist不能同时为空，单次请求长度不超过100
     */
    public Response deltagusers(Integer tagid, List ... values){
        String tagDeltagusersURL=commonTools.getTagDeltagusersURL();
        return tagUserCommon(tagDeltagusersURL,values);
    }
    public Response deltagusers(Integer tagid, String listname,ArrayList list){
        String tagDeltagusersURL=commonTools.getTagDeltagusersURL();
        HashMap<String,Object> data = new HashMap<>();
        data.put("tagid",tagid);
        data.put(listname,list);
        return given().contentType(ContentType.JSON).body(data)
                .when().post(tagDeltagusersURL).then().extract().response();
    }
    /*
    tag操作通用代码
     */
    public Response tagUserCommon(String URL,List ... values){
        HashMap<String,Object> data = new HashMap<>();
        data.put("tagid",tagid);
        if(values.length==2){
            data.put("userlist",values[0]);
            data.put("partylist",values[1]);
        }
        return given().contentType(ContentType.JSON).body(data)
                .when().post(URL).then().extract().response();
    }
    /*
    获取标签列表
     */
    public Response getTagList(){
        String tagListURL=commonTools.getTagListURL();
        return given().get(tagListURL).then().extract().response();
    }




}
