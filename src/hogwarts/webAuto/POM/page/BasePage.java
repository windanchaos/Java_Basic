package hogwarts.webAuto.POM.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {
    /*
    静态变量，所有子类共享，驱动浏览器的测试case。
     */
    static WebDriver driver = new ChromeDriver();
    public BasePage(){
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    public WebElement findElement(By by) {
        return driver.findElement(by);
    }
    public WebElement findElement(By by,int timeout) {
        waitClickable(by,timeout);
        return driver.findElement(by);
    }
    public WebElement findAndMoveElement(By by){
        if(!driver.findElement(by).isEnabled()){new Actions(driver).moveToElement(driver.findElement(by));}
        return findElement(by);
    }
    //等待可见
    public void waitVisibable(By by){
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    //等待可点击
    public void waitClickable(By by,int timeout){
        waitVisibable(by);
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(by));
    }
    //等待可点击
    public void waitClickable(WebElement element,int timeout){
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
    }

}
