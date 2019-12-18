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


}
