package hogwarts.webAuto.POM.page;

import org.openqa.selenium.By;

public class ManageToolsPage extends BasePage {
    public ManageToolsPage switchToMaterial(){
        findElement(By.xpath("//a[@href='#material/text']")).click();
        return this;
    }

    public ManageToolsPage materialAddPic(String pic){
        switchToMaterial();
        findElement(By.xpath("//div[@id='profile_navigation']/ul/li/a[contains(text(),'图片')]")).click();
        findElement(By.linkText("添加图片")).click();
        findElement(By.xpath("//input[@id='js_upload_input']")).sendKeys(pic);
        String[] split=pic.split(java.io.File.separator+java.io.File.separator);
        System.out.println(split[split.length - 1]);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("//div[contains(text()," + split[split.length - 1] + ")]");
        //拼接xpath的坑，必须加上单引号
        waitVisibable(By.xpath("//div[contains(text(),'"+split[split.length-1]+"')]"));
        findElement(By.linkText("完成")).click();
        return this;
    }
    public ManageToolsPage addPicText(String title,String text, String pic){
        switchToMaterial();
        findElement(By.xpath("//div[@id='profile_navigation']/ul/li/a[contains(text(),'图文')]")).click();
        findElement(By.linkText("添加图文")).click();
        //findElement(By.linkText("在此输入标题"),2).sendKeys(title);
        driver.switchTo().frame(0);
        findElement(By.tagName("p"),2).sendKeys(text);
        driver.switchTo().defaultContent();
        findElement(By.className("msg_infoItem_coverPlaceHolder"),2).click();
        driver.findElements(By.xpath("//input[@class='ww_fileInput js_file']")).get(0).sendKeys(pic);
        findElement(By.linkText("确定"),2).click();
        driver.findElements(By.xpath("//input[@class='ww_editorTitle ww_compatibleTxt_ipt js_amrd_title']")).get(0).sendKeys(title);
        findElement(By.linkText("完成"),2).click();
        return this;
    }
}
