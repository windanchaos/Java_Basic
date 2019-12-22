package hogwarts.webAuto.POM.testcase;

import hogwarts.webAuto.POM.page.IndexPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestManageTools {
    public static IndexPage indexPage;
    @Before
    public void setUp(){
        indexPage=new IndexPage();
        indexPage.loginWithCookies();
    }
    @After
    public void tearDown(){
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        indexPage.quit();
    }
    @Test
    public void addPicture(){
        indexPage.switchManageToolsPage().materialAddPic("C:\\Users\\Administrator\\Pictures\\deskPic\\1d96579fe8efb234f9e226760e43c5dd.jpg");
    }
    @Test
    public void addPicText(){
        String text="为何现在只剩下 风吹乱我的发\n" +
                "撕开我记忆的伤疤\n" +
                "让往事像雾气慢慢地蒸发\n" +
                "让我知道什么叫放不下\n" +
                "为何我的泪 会不停地流下\n" +
                "滑过你曾经亲吻的脸颊\n" +
                "所有的对错在顷刻 崩塌\n";
        String pic="C:\\Users\\Administrator\\Pictures\\deskPic\\1d96579fe8efb234f9e226760e43c5dd.jpg";
        indexPage.switchManageToolsPage().addPicText("飘雪",text,pic);
    }


}
