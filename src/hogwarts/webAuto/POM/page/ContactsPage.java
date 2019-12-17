package hogwarts.webAuto.POM.page;

import org.openqa.selenium.By;

public class ContactsPage extends BasePage{
    public ContactsPage addContact(String username,String memberAdd_acctid,String memberAdd_phone){
        findElement(By.id("username")).sendKeys(username);
        findElement(By.id("memberAdd_acctid")).sendKeys(memberAdd_acctid);
        findElement(By.id("memberAdd_phone")).sendKeys(memberAdd_phone);
        return this;
    }
}
