package testcase;

import page.IndexPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestWework {
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
    public void addContacts(){
        indexPage.toContact().addContact("test01","1212321311","18781901171");
        indexPage.switchIndexPage();
        indexPage.toContact().addContact("test02","1212321312","18781901172");
        indexPage.switchIndexPage();
        indexPage.toContact().addContact("test03","1212321313","18781901173");
    }

    @Test
    public void searchDelContact(){
        indexPage.switchContactsPage().searchAndDelContact("test01");
    }

    @Test
    public void chooseDelContact(){
        indexPage.switchContactsPage().chooseAndDelContact();
    }
    @Test
    public void importContactFromFile(){
        indexPage.switchContactsPage().importFromFile("D:\\Code\\Java_Basic\\src\\hogwarts\\webAuto\\POM\\" +
                "data\\通讯录批量导入模板.xlsx");
    }
    @Test
    public void showGroups(){
        indexPage.switchContactsPage().showAllGroup();
    }
    @Test
    public void addGroup(){
        indexPage.switchContactsPage().addGroup("A-1","A-1-1");
    }
    @Test
    public void searchGroupDel(){
        indexPage.switchContactsPage().searchGroupDel("A-1-1");
    }
}
