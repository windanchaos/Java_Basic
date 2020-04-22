package xke.po.crm;

import xke.po.frame.CommonTools;
import xke.po.frame.AppBase;

//todo，初始化后直接返回
public class OrderList extends AppBase {
    public OrderList() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(CommonTools.title_back);
    }
}
