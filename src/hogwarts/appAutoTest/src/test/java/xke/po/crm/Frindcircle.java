package xke.po.crm;

import xke.po.frame.CommonTools;
import xke.po.frame.AppBase;

//朋友圈
public class Frindcircle extends AppBase {
    public Frindcircle browser(int srollTimes) {
        for (int i = 0; i < srollTimes; i++) {
            srollUp();
        }
        return this;
    }

    public CRM backCRM() {
        click(CommonTools.title_back);
        return new CRM();
    }

}
