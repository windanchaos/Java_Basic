package main.java.department.test;

import io.restassured.response.Response;
import main.java.department.api.DepartmentModel;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class TestDepartment {
    DepartmentModel model=new DepartmentModel();
    @Test
    public void testCreate(){
        Response rp=model.create("测试部门3",null,2,2,23);
        rp.then().body("errcode",equalTo(0)).body("errmsg",equalTo("created"));
    }
    @Test
    public void testGetList(){
        System.out.println(model.getAll().toString());
    }
}
