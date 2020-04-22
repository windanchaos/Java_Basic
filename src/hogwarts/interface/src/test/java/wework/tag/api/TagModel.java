package wework.tag.api;

import io.restassured.response.Response;
import wework.base.DataDriveBase;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class TagModel extends DataDriveBase {


    /*
    创建标签
    参数说明：

    参数	必须	说明
    access_token	是	调用接口凭证
    tagname	是	标签名称，长度限制为32个字以内（汉字或英文字母），标签名不可与其他标签重名。
    tagid	否	标签id，非负整型，指定此参数时新增的标签会生成对应的标签id，不指定时则以目前最大的id自增。
     */
    public Response create(String tagname, Integer... values) {
        HashMap<String, Object> data = new HashMap<>();
        data.put("tagname", tagname);
        //tagid传值就带入
        if (values.length == 1) {
            data.put("tagid", values[0]);
        }
        return deSerialize().get("create").run(data);
    }

    /*
    更新标签名字
    参数说明：

    参数	必须	说明
    access_token	是	调用接口凭证
    tagid	是	标签ID
    tagname	是	标签名称，长度限制为32个字（汉字或英文字母），标签不可与其他标签重名。
     */
    public Response update(Integer tagid, String tagname) {
        HashMap<String, Object> data = new HashMap<>();
        data.put("tagname", tagname);
        data.put("tagid", tagid);
        return deSerialize().get("update").run(data);
    }

    public Response list() {
        return deSerialize().get("list").run();
    }

}
