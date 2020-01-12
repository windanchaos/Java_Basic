package wework.department.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import tools.CommonTools;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

/*
测试模型构建，使测试断言和模型分离。
业务对象的封装，类似PO
框架层的封装，完成对API的驱动
配置模块
数据封装
 */
public class DepartmentModel {
    /*
    接口返回对象的数据类型来构建模型，但是初始化只用局部
    企业微信接口文档地址：https://work.weixin.qq.com/api/doc/90000/90135/90207
     */
    private int id;
    private String name;
    private String name_en;
    private int parentid;
    private int order;
    private CommonTools commonTools=CommonTools.getInstance();

    public DepartmentModel(){
    }
    public DepartmentModel(int id){
        this.id=id;
    }
    /*
    取所有list的方法意义目前看不大
     */
    public List<LinkedHashMap> getAll(){
        String departmentListURL=commonTools.getDepartmentListURL();
        //拿到全部部门
        return given().get(departmentListURL).then().extract().response().getBody().jsonPath().getJsonObject("wework/department");
    }

    /*
    接口
     */
    /*
    创建部门
    参数	            必须	说明
    access_token	是	调用接口凭证
    name	是	部门名称。长度限制为1~32个字符，字符不能包括\:?”<>｜
    name_en	否	英文名称，需要在管理后台开启多语言支持才能生效。长度限制为1~32个字符，字符不能包括\:?”<>｜
    parentid	是	父部门id，32位整型
    order	否	在父部门中的次序值。order值大的排序靠前。有效的值范围是[0, 2^32)
    id	否	部门id，32位整型，指定时必须大于1。若不填该参数，将自动生成id
    param:
        values 代表order 和id。
        一个方法中只能使用一个不定参数。
        不定参数必须是方法中最后一个参数。
     */
    public Response create(String name,String name_en, Integer parentid,Integer ...values ){
        String departmentCreateURL=commonTools.getDepartmentCreateURL();
        System.out.println(commonTools.getToken());
        HashMap<String,Object> data=new HashMap<>();
        if(values.length==1){
            data.put("order",values[0]);
        }
        if(values.length==2){
            data.put("order",values[0]);
            data.put("id",values[1]);
        }
        data.put("name",name);
        data.put("name_en",name_en);
        data.put("parentid",parentid);
        return given().contentType(ContentType.JSON)
                .body(data).post(departmentCreateURL).then().extract().response().prettyPeek();
    }

    /*
    更新部门
    参数说明：

    参数	必须	说明
    access_token	是	调用接口凭证
    id	是	部门id
    name	否	部门名称。长度限制为1~32个字符，字符不能包括\:?”<>｜
    name_en	否	英文名称，需要在管理后台开启多语言支持才能生效。长度限制为1~32个字符，字符不能包括\:?”<>｜
    parentid	否	父部门id
    order	否	在父部门中的次序值。order值大的排序靠前。有效的值范围是[0, 2^32)
     */
    public Response update(Integer id){
        String departmentUpdateURL=commonTools.getDepartmentUpdateURL();
        HashMap<String,Object> data=new HashMap<>();
        data.put("id",id);
        return given().contentType(ContentType.JSON)
                .get(departmentUpdateURL).then()
                .extract().response();
    }
    /*
    删除部门
    参数说明 ：

    参数	必须	说明
    access_token	是	调用接口凭证
    id	否	部门id。（注：不能删除根部门；不能删除含有子部门、成员的部门）
     */
    public Response del(Integer id){
        String departmentDeleteURL=commonTools.getDepartmentDeleteURL();
        HashMap<String,Object> data=new HashMap<>();
        data.put("id",id);
        return given().contentType(ContentType.JSON)
                .get(departmentDeleteURL).then()
                .extract().response();
    }
}
