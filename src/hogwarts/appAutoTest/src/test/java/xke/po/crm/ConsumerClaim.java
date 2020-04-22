package xke.po.crm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import xke.po.frame.AppBase;
import xke.po.frame.CommonTools;

import java.util.HashMap;
import java.util.List;

/**
 * 用户认领
 */
public class ConsumerClaim extends AppBase {
    private By unclaim;
    private By claimed;
    private By search;
    private By searchTxt;
    private By checker;
    private By element;
    private By claimButton;

    public ConsumerClaim(Boolean starDirect) {
        super(".client.view.claim.ClaimA`ctivity");
        HashMap<String, By> elements = getElementsByConfig();
        //反射方式设置实例中的定位元素的值
        CommonTools.setByFields(this, elements);
    }


    /**
     * @param name 收集的人的名称
     * @return
     */
    public ConsumerClaim claim(String name) {
        //替换配置中的关键字
        System.out.println(element.toString());
        //替换参数
        element = replaceKey(element, "key", name);
        scrollFindElement(checker, element);
        //替换参数
        claimButton = replaceKey(claimButton, "key", name);
        driver.findElement(claimButton).click();
        return this;
    }

    //点击未认领
    public ConsumerClaim unclaimTab() {
        parseSteps();
        return this;
    }

    //点击已认领
    public ConsumerClaim claimedTab() {
        parseSteps();
        return this;
    }

    public List<WebElement> search(String text) {
        click(search);
        sendkeys(searchTxt, text);
        List<WebElement> list = driver.findElements(By.id("com.maike51.xke:id/tvnick"));
        //click(delete);
        return driver.findElements(By.id("com.maike51.xke:id/tvnick"));
    }

}
