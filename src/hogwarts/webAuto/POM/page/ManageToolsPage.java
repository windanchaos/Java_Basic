package hogwarts.webAuto.POM.page;

import org.openqa.selenium.By;

public class ManageToolsPage extends BasePage {
    public ManageToolsPage switchToMaterial(){
        findElement(By.xpath("//a[@href='#material/text']")).click();
        return this;
    }

    public ManageToolsPage materialAddPic(String pic){
        switchToMaterial();
        driver.findElements(By.xpath("//div[@id='profile_navigation']/ul/li/a[contains(text(),'图片')]")).get(0).click();
        findElement(By.linkText("添加图片")).click();
        findElement(By.xpath("//input[@id='js_upload_input']")).sendKeys(pic);
        findElement(By.linkText("完成")).click();
        return this;
    }
}
