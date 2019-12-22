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
            Thread.sleep(20 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        indexPage.quit();
    }
    @Test
    public void addPicture(){
        indexPage.switchManageToolsPage().materialAddPic("C:\\Users\\Administrator\\Pictures\\deskPic\\1d96579fe8efb234f9e226760e43c5dd.jpg");
    }


}
