package hogwarts.webAuto.POM.page;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.HashSet;
import java.util.List;

public class ContactsPage extends BasePage {
    HashSet<String> clickHistory = new HashSet<>();

    public ContactsPage addContact(String username, String memberAdd_acctid, String memberAdd_phone) {
        findElement(By.id("username")).sendKeys(username);
        findElement(By.id("memberAdd_acctid")).sendKeys(memberAdd_acctid);
        findElement(By.id("memberAdd_phone")).sendKeys(memberAdd_phone);
        findElement(By.linkText("保存")).click();
        waitClickable(By.linkText("立即邀请"), 2);
        return this;
    }

    //查询删除账户
    public ContactsPage searchAndDelContact(String Contact) {
        findElement(By.id("memberSearchInput")).sendKeys(Contact);
        findElement(By.className("ww_searchResult_title_peopleName")).click();
        waitClickable(By.linkText("删除"), 3);
        findElement(By.linkText("删除")).click();
        waitClickable(By.linkText("确认"), 3);
        findElement(By.linkText("确认")).click();
        return this;
    }

    //勾选删除账户
    public ContactsPage chooseAndDelContact() {
        List<WebElement> elementList = driver.findElements(By.className("ww_checkbox"));
        driver.findElements(By.className("ww_checkbox")).subList(1, elementList.size() - 1).forEach(webElement -> webElement.click());
        findElement(By.linkText("删除")).click();
        waitClickable(By.linkText("确认"), 3);
        findElement(By.linkText("确认")).click();
        return this;
    }

    //文件导入
    public ContactsPage importFromFile(String path) {
        findElement(By.linkText("批量导入/导出")).click();
        waitClickable(By.linkText("文件导入"), 2);
        findElement(By.linkText("文件导入")).click();
        findElement(By.id("js_upload_file_input")).sendKeys(path);
        findElement(By.linkText("确认导入")).click();
        return this;
    }

    /*
    部门管理、增删改查
     */
    public ContactsPage addGroup(String parent, String group) {
        //查询

        searchClickSearchResult(parent);
        //查询
        findElement(By.linkText("添加子部门"), 2).click();
        //输入
        findElement(By.xpath("//input[@class='qui_inputText ww_inputText' and @name='name']"), 2).sendKeys(group);
        findElement(By.linkText("确定"), 2).click();
        return this;
    }

    /*
    部门查删
     */
    public ContactsPage searchGroupDel(String group) {
        showAllGroup();
        findElement(By.linkText(group), 2).findElement(By.tagName("span")).click();
        findElement(By.linkText("删除"), 2).click();
        findElement(By.linkText("确定"), 1).click();
        return this;
    }

    /*
    通用方法，点击查询结果
     */
    public ContactsPage searchClickSearchResult(String search) {
        findElement(By.id("memberSearchInput")).sendKeys(search);
        try {
            findElement(By.className("member_colLeft_bottom")).findElement(By.linkText(search)).click();
        } catch (ElementNotInteractableException e) {
            throw e;
        }
        return this;
    }

    /*
    自动遍历点开所有层级的数据
     */
    public ContactsPage showAllGroup() {
        //初始化，会默认展开2级部门，从这里开始遍历
        List<WebElement> tree = driver.findElements(By.xpath("//ul[@class='jstree-children' and @role='group']"));
        for (int i = 0; i < tree.size(); i++) {
            showGroup(tree.get(i), clickHistory);
        }
        return this;
    }

    public ContactsPage showGroup(WebElement element, HashSet<String> clickHistory) {
        List<WebElement> groups = getGroups(element);
        int history = clickHistory.size();
        if (null != groups) {
            for (int i = 0; i < groups.size(); i++) {

                //等待展开按钮
                waitClickable(groups.get(i).findElement(By.xpath("child::i")), 5);
                //展开按钮同级的a标签文本（部门名称）
                if (!clickHistory.contains(groups.get(i).findElement(By.xpath("child::a")).getText())) {
                    //放入点击历史
                    clickHistory.add(groups.get(i).findElement(By.xpath("child::a")).getText());
                    System.out.println("点击:" + groups.get(i).findElement(By.xpath("child::a")).getText());
                    //展开按钮可见则点击
                    if (groups.get(i).findElement(By.xpath("child::i")).isDisplayed())
                        groups.get(i).findElement(By.xpath("child::i")).click();
                    System.out.println("记录历史大小：" + clickHistory.size());
                }

            }
            //当点击历史不再增加，则表明点击完成，循环不在进行
            if (history != clickHistory.size()) {
                //因为结构变化，需重新调用主函数
                showAllGroup();
            }
        }
        return this;
    }

    private List<WebElement> getGroups(WebElement element) {
        List<WebElement> group = null;
        //在元素中找元素
        waitVisibable(By.cssSelector("[aria-level]"));
        try {
            group = element.findElements(By.cssSelector("[aria-level]"));
        } catch (StaleElementReferenceException e) {
        }

        return group;
    }

}
