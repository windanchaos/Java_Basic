package hogwarts.webAuto.POM.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactsPage extends BasePage{
    public ContactsPage addContact(String username,String memberAdd_acctid,String memberAdd_phone){
        findElement(By.id("username")).sendKeys(username);
        findElement(By.id("memberAdd_acctid")).sendKeys(memberAdd_acctid);
        findElement(By.id("memberAdd_phone")).sendKeys(memberAdd_phone);
        findElement(By.linkText("保存")).click();
        waitClickable(By.linkText("立即邀请"),2);
        return this;
    }
    //查询删除账户
    public ContactsPage searchAndDelContact(String Contact){
        findElement(By.id("memberSearchInput")).sendKeys(Contact);
        findElement(By.className("ww_searchResult_title_peopleName")).click();
        waitClickable(By.linkText("删除"),3);
        findElement(By.linkText("删除")).click();
        waitClickable(By.linkText("确认"),3);
        findElement(By.linkText("确认")).click();
        return this;
    }

    //勾选删除账户
    public ContactsPage chooseAndDelContact(){
        List<WebElement> elementList=driver.findElements(By.className("ww_checkbox"));
        driver.findElements(By.className("ww_checkbox")).subList(1,elementList.size()-1).forEach(webElement -> webElement.click());
//        elementList = driver.findElements(By.className("ww_checkbox"));
//        for(int i=1;i<elementList.size()-1;i++){
//            elementList.get(i).click();
//        }
        findElement(By.linkText("删除")).click();
        waitClickable(By.linkText("确认"),3);
        findElement(By.linkText("确认")).click();
        return this;
    }

    //文件导入
    public ContactsPage importFromFile(String path){
        findElement(By.linkText("批量导入/导出")).click();
        waitClickable(By.linkText("文件导入"),2);
        findElement(By.linkText("文件导入")).click();
        findElement(By.id("js_upload_file_input")).sendKeys(path);
        findElement(By.linkText("确认导入")).click();
        return this;
    }

    //部门管理、增删改查
    /*
    class=icon jstree-contextmenu-hover 表示组可见，它的父级就是元素
     */

    public ContactsPage showAllGroup(){
        //找到部分的顶级元素
        WebElement tree = driver.findElement(By.xpath("//ul[@class='jstree-children']"));
        showGroup(tree);
        return this;
    }

    public ContactsPage showGroup(WebElement element){
        List<WebElement> groups =getGroups(element);
        if(null!=groups){
            for(int i=0;i<groups.size();i++){
                System.out.println(groups.get(i).findElements(By.xpath("//span[@class='icon jstree-contextmenu-hover']/parent::a")).size());
                groups.get(i).findElement(By.xpath("//span[@class='icon jstree-contextmenu-hover']/parent::a")).click();
                showGroup(groups.get(i));
            }
        }else element.findElement(By.xpath("//span[@class='icon jstree-contextmenu-hover']/parent::a")).click();
        return this;
    }

    private List<WebElement> getGroups(WebElement element){
        //在元素中找元素
        List<WebElement> group = element.findElements(By.className("jstree-contextmenu-hover"));
        return group;
    }

}
