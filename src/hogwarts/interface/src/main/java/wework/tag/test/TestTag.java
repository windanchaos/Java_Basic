package wework.tag.test;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import wework.tag.api.Tag;
import org.junit.jupiter.api.Test;
import wework.tag.api.TagModel;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.Matchers.equalTo;

/*
目前还未没有考虑重复执行的问题
 */
public class TestTag {
    static Tag model = new Tag();
    static TagModel model2 = new TagModel();

    @Test
    public void testCreate(){
        model.create("UI").then().body("errcode",equalTo(0)).body("errmsg",equalTo("created"));
    }
    @Test
    public void testCreate2(){
        model2.create("UI").then().body("errcode",equalTo(0)).body("errmsg",equalTo("created"));
    }
    @Test
    public void testCreateWithTagid(){
        model.create("UI2",2).then().body("errcode",equalTo(0)).body("errmsg",equalTo("created"));
    }

    @Test
    public void testUpdate(){
        model.update(1,"换了个名字").then().body("errcode",equalTo(0)).body("errmsg",equalTo("updated"));
    }
    @Test
    public void testUpdate2(){
        model2.update(1,"换了个名字ah").then().body("errcode",equalTo(0)).body("errmsg",equalTo("updated"));
    }
    @Test
    public void testDel(){
        model.create("要被删除的",3).then().body("errcode",equalTo(0)).body("errmsg",equalTo("created"));
        model.delete(3).then().body("errcode",equalTo(0)).body("errmsg",equalTo("deleted"));
    }
    //testGetTagUser没有强的业务逻辑断言
    @Test
    public void testGetTagUser(){
        model.getUserList(1).then().body("errcode",equalTo(0)).body("errmsg",equalTo("ok"));
    }
    @Test
    public void testAddTagUser(){
        ArrayList<String> list=new ArrayList();
        list.add("YaoBo");
        model.addtagusers(1,"userlist",list).then().body("errmsg",equalTo("ok"));
    }
    @Test
    public void testAddTagDepartment(){
        ArrayList<Integer> list=new ArrayList();
        list.add(1);
        model.addtagusers(1,"partylist",list).then().body("errmsg",equalTo("ok"));
    }
    @Test
    public void testDelTagUser(){
        ArrayList<String> list=new ArrayList();
        list.add("YaoBo");
        model.deltagusers(1,"userlist",list).then().body("errmsg",equalTo("deleted"));
    }
    @Test
    public void testDelTagDepartmen(){
        ArrayList<Integer> list=new ArrayList();
        list.add(1);
        model.deltagusers(1,"partylist",list).then().body("errmsg",equalTo("deleted"));
    }
    @Test
    public void testGetTagList2(){
        model2.list().then().body("errcode",equalTo(0)).body("errmsg",equalTo("ok"));
    }
    @Test
    public void testGetTagList(){
        model.getTagList().then().body("errcode",equalTo(0)).body("errmsg",equalTo("ok"));
    }

    @Test
    public void testMustache() throws IOException {
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("name", "Mustache");
        Writer writer = new StringWriter();
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache mustache = mf.compile(new StringReader("I say:{{name}}, {{name}}!"), "example");
        mustache.execute(writer, data);
        writer.flush();
        System.out.println(writer.toString());
    }

    @Test
    public void testCurrentThread(){
        StackTraceElement[] elements=Thread.currentThread().getStackTrace();
        for(int i=0;i<elements.length;i++){
            System.out.println(elements[i].getClass());
            System.out.println(elements[i].getMethodName());
            System.out.println(elements[i].toString());
            System.out.println("##############################");
        }
    }
}
