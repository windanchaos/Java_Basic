package hogwarts.webAuto.POM.page;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.HashSet;
import java.util.List;

public class ContactsPage extends BasePage{
    HashSet<WebElement> clickHistory=new HashSet<>();
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

    /*
    部门管理、增删改查
     */
    public ContactsPage addGroup(String parent,String group){
        //查询

        searchClickSearchResult(parent);
        //查询
        findElement(By.linkText("添加子部门"),2).click();
        //输入
        findElement(By.xpath("//input[@class='qui_inputText ww_inputText' and @name='name']"),2).sendKeys(group);
        findElement(By.linkText("确定"),2).click();
        return this;
    }

    /*
    部门查删
     */
    public ContactsPage searchGroupDel(String group){
        showAllGroup();
        findElement(By.linkText(group),2).findElement(By.tagName("span")).click();
        findElement(By.linkText("删除"),2).click();
        findElement(By.linkText("确定"),1).click();
        return this;
    }

    /*
    通用方法，点击查询结果
     */
    public ContactsPage searchClickSearchResult(String search){
        findElement(By.id("memberSearchInput")).sendKeys(search);
        try{
            findElement(By.className("member_colLeft_bottom")).findElement(By.linkText(search)).click();
        }catch (ElementNotInteractableException e)
        {
            throw e;
        }
        return this;
    }

    /*
    自动便利点开所有层级的数据
     */
    public ContactsPage showAllGroup(){
        //找到部分的顶级元素
        WebElement tree = driver.findElement(By.xpath("//ul[@class='jstree-children']"));
        showGroup(tree,clickHistory);
        return this;
    }

    public ContactsPage showGroup(WebElement element,HashSet<WebElement> clickHistory){
        List<WebElement> groups =getGroups(element);
        System.out.println("找到的元素大小"+groups.size());
        if(null!=groups){
            for(int i=0;i<groups.size();i++){
                //不包含就点击
                if(!clickHistory.contains(groups.get(i))){
                    //压制最后一步的错误
                    try{
                        waitClickable(groups.get(i),3);
                        System.out.println(groups.get(i).getText());
                        //点击两次展开
                        groups.get(i).click();

                        //点击后放入
                        clickHistory.add(groups.get(i));
                        groups.get(i).click();
                    }catch (StaleElementReferenceException e){
                        System.out.println("结束");
                        return this;
                    }
                }
            }
            //因为结构变化，需重新调用主函数
            showAllGroup();
        }
        return this;
    }

    private List<WebElement> getGroups(WebElement element){
        //在元素中找元素
        waitVisibable(By.cssSelector("[aria-level]"));
        List<WebElement> group = element.findElements(By.cssSelector("[aria-level]"));
        return group;
    }

}
