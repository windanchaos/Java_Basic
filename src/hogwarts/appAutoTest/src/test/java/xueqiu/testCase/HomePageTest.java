package xueqiu.testCase;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import xueqiu.PO.HomePage;

import static org.hamcrest.MatcherAssert.assertThat;

public class HomePageTest {
    static HomePage homePage;

    @BeforeAll
    public static void setUp() {
        homePage = new HomePage();
    }

    @Test
    public void testhomePage() {
        homePage.getPopular();
        assertThat("检查元素是否存在", homePage.elementExist("//*[@text='雪球热股']"));
    }

    @Test
    public void getRecommend() {
        homePage.getRecommend();
        assertThat("检查元素是否存在", homePage.elementExist("//*[@class='android.widget.LinearLayout']"));
    }

    @Test
    public void testgetFocus() {
        homePage.getFocus();
        assertThat("检查元素是否存在", homePage.elementExist("//*[@class='android.widget.LinearLayout']"));
    }
}
