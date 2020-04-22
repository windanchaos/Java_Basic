package xke.po.crm;

import org.openqa.selenium.By;
import xke.po.frame.CommonTools;
import xke.po.frame.AppBase;

import java.lang.reflect.Field;
import java.util.HashMap;

//客户信息类
public class ConsumerInfo extends AppBase {
    //朋友圈
    private By frindcircleID;
    //历史订单
    private By orderListXpath;
    //其他信息
    private By otherInfoID;
    //解绑客户
    private By unbundID;
    //发送消息
    private By send_msgID;
    //备注输入框
    private By remark_editID;
    //电话输入框
    private By phone_editID;
    //标签标题（作滚屏标识）
    private By checkerID;
    //标签列
    private By label_chooseID;
    private By label_chooseID2;

    public ConsumerInfo() {
        super(null);
        HashMap<String, By> elements = getElementsByConfig();
        //反射方式设置实例中的定位元素的值
        CommonTools.setByFields(this, elements);
    }

    public Frindcircle frindcircle() {
        click(frindcircleID);
        return new Frindcircle();
    }

    public OrderList orderList() {
        click(orderListXpath);
        return new OrderList();
    }

    //编辑用户信息
    public ConsumerInfo editInfo(HashMap<String, String[]> tags, String phone, String comment) {
        click(CommonTools.title_right_btn);
        click(remark_editID);
        sendkeys(remark_editID, comment);
        sendkeys(phone_editID, phone);
        click(label_chooseID);
        addTag(tags);
        return this;
    }

    private ConsumerInfo addTag(HashMap<String, String[]> tags) {
        for (String key : tags.keySet()) {
            String[] tagvalues = tags.get(key);
            scrollFindElement(checkerID, CommonTools.TextViewXpathTextGeneratorStrict(key));
            click(CommonTools.TextViewXpathTextGeneratorStrict(key));
            for (int j = 0; j < tagvalues.length; j++) {
                click(CommonTools.TextViewXpathTextGeneratorStrict(tagvalues[j]));
            }
            //收起，避免显示问题
            click(CommonTools.TextViewXpathTextGeneratorStrict(key));
        }
        click(CommonTools.title_right_btn);
        click(CommonTools.title_right_btn);
        click(CommonTools.title_back);
        return this;
    }

}
