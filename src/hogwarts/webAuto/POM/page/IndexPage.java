package hogwarts.webAuto.POM.page;

import hogwarts.webAuto.POM.utils.ConfigUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class IndexPage extends BasePage{
    public static String url="https://work.weixin.qq.com/";
    public IndexPage loginWithCookies(){
        driver.navigate().to(url);
        ConfigUtil.setCookieConfig(driver);
        driver.findElement(By.linkText("企业登录")).click();
        return this;
    }
    //退出
    public void quit(){
        driver.quit();
    }
    //首页
    public IndexPage switchIndexPage(){
        findElement(By.id("menu_index")).click();
        return this;
    }
    //通讯录
    public ContactsPage switchContactsPage(){
        findElement(By.id("menu_contacts")).click();
        try{
            waitClickable(By.linkText("立即邀请"),3);
        }
        catch (NoSuchElementException e){

        }finally {
            return new ContactsPage();
        }
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
    //添加成员
    public ContactsPage toContact(){
        waitClickable(By.linkText("添加成员"),2);
        findElement(By.linkText("添加成员")).click();
        return new ContactsPage();
    }

    //导入通讯录
    public ContactsPage toAddContact(){
        findElement(By.linkText("导入通讯录")).click();
        return new ContactsPage();
    }

    //成员加入
    public CustomerPage toMemberJoin(){
        findElement(By.linkText("成员加入  ")).click();
        return new CustomerPage();
    }

    //消息群发
    public ManageToolsPage toCreateMessage(){
        findElement(By.linkText("消息群发")).click();
        return new ManageToolsPage();
    }

    //客户联系
    public CustomerPage toCustomer(){
        findElement(By.linkText("客户联系")).click();
        return new CustomerPage();
    }

    //微信红包封面
    public AppsPage toHongbao(){
        findElement(By.name("微信红包封面")).click();
        return new AppsPage();
    }
}
