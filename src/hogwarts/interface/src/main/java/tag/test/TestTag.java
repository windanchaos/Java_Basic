package main.java.tag.test;

import main.java.tag.api.TagModel;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.equalTo;

/*
目前还未没有考虑重复执行的问题
 */
public class TestTag {
    static TagModel model = new TagModel();

    @Test
    public void testCreate(){
        model.create("UI").then().body("errcode",equalTo(0)).body("errmsg",equalTo("created"));
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
    public void testGetTagList(){
        model.getTagList().then().body("errcode",equalTo(0)).body("errmsg",equalTo("ok"));
    }

}
