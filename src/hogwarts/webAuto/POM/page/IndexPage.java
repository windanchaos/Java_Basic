package hogwarts.webAuto.POM.page;

import org.openqa.selenium.By;

public class IndexPage extends BasePage{
    public IndexPage(){
        //driver.manage().addCookie();
        driver.get("");
    }
    //首页
    public IndexPage switchIndexPage(){
        findElement(By.id("menu_index")).click();
        return this;
    }
    //通讯录
    public ContactsPage switchContactsPage(){

        return new ContactsPage();
    }
    //应用管理
    public AppsPage switchAppPage(){
        findElement(By.id("menu_apps")).click();
        return new AppsPage();
    }
    //客户联系
    public CustomerPage switchCustomerPage(){
        findElement(By.id("menu_customer")).click();
        return new CustomerPage();
    }
    //管理工具
    public ManageToolsPage switchManageToolsPage(){
        findElement(By.id("menu_manageTools")).click();
        return new ManageToolsPage();
    }
    //我的企业
    public ProfilePage switchProfilePage(){
        findElement(By.id("menu_profile")).click();
        return new ProfilePage();
    }
    //常用入口
    public CommonEntrance commonEntrance(){
        return new CommonEntrance();
    }
}
/*
常用入口的PO
 */
class CommonEntrance extends BasePage{
    //添加成员
    public ContactsPage toContact(){
        findElement(By.name("添加成员")).click();
        return new ContactsPage();
    }

    //导入通讯录
    public ContactsPage toAddContact(){
        findElement(By.name("导入通讯录")).click();
        return new ContactsPage();
    }

    //成员加入
    public CustomerPage toMemberJoin(){
        findElement(By.name("成员加入  ")).click();
        return new CustomerPage();
    }

    //消息群发
    public ManageToolsPage toCreateMessage(){
        findElement(By.name("消息群发")).click();
        return new ManageToolsPage();
    }

    //客户联系
    public CustomerPage toCustomer(){
        findElement(By.name("客户联系")).click();
        return new CustomerPage();
    }

    //微信红包封面
    public AppsPage toHongbao(){
        findElement(By.name("微信红包封面")).click();
        return new AppsPage();
    }
}
