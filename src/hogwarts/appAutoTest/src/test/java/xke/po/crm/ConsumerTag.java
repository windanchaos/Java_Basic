package xke.po.crm;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import frame.CommonTools;
import frame.AppBase;

import java.util.HashMap;

//客户标签
public class ConsumerTag extends AppBase {
    private By addID = By.id("com.maike51.xke:id/add");
    private By editTextID = By.id("com.maike51.xke:id/edittext");

    /**
     * 两种初始化方式
     */
    public ConsumerTag() {
        super();
        HashMap<String, By> elements = getElementsByConfig();
        //反射方式设置实例中的定位元素的值
        CommonTools.setByFields(this, elements);
    }

    public ConsumerTag(Boolean starDirect) {
        super(".client.view.group.GroupListActivity");
        HashMap<String, By> elements = getElementsByConfig();
        //反射方式设置实例中的定位元素的值
        CommonTools.setByFields(this, elements);

    }

    //添加标签
    public ConsumerTag create(String tagName) {
        click(CommonTools.title_right_btn);
        sendkeys(editTextID, tagName);
        click(CommonTools.title_right_btn);
        gobackCRM();
        return this;
    }

    //添加标签并添加一个用户
    public ConsumerTag createAndAddconsumer(String tagName, String consumerName) {
        click(CommonTools.title_right_btn);
        sendkeys(editTextID, tagName);
        click(addID);
        //找元素
        chooseConsumer(consumerName);
        //保存选择
        click(CommonTools.title_right_btn);
        //保存标签
        WebDriverWait wait = new WebDriverWait(driver, 2, 500);
        click(CommonTools.title_right_btn);
        gobackCRM();
        return this;
    }

    //添加标签并添加一个用户
    public ConsumerTag createAndAddconsumers(String tagName, String[] consumerNames) {

        click(CommonTools.title_right_btn);
        sendkeys(editTextID, tagName);
        click(addID);
        for (int i = 0; i < consumerNames.length; i++) {
            click(CommonTools.TextViewXpathTextGenerator(consumerNames[i]));
        }
        click(CommonTools.title_right_btn);
        click(CommonTools.title_right_btn);
        gobackCRM();
        return this;
    }

    //滑屏查找
    private boolean chooseConsumer(String consumerName) {
        //通过第一个用户变化与否来决定是否停止滑动
        if (scrollFindElement(By.id("com.maike51.xke:id/name"), CommonTools.TextViewXpathTextGenerator(consumerName))) {
            click(CommonTools.TextViewXpathTextGenerator(consumerName));
            return true;
        }
        return false;
    }

    private ConsumerTag gobackCRM() {
        click(CommonTools.title_back);
        return this;
    }
}
