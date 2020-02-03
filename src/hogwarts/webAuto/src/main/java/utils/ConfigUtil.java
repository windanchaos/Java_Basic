package hogwarts.webAuto.POM.utils;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ConfigUtil {
    private static  String[] cookies = {"wwrtx.refid","wwrtx.sid","wwrtx.vst"};
    public static boolean setCookieConfig(WebDriver driver){
        Configurations configs = new Configurations();
        Configuration config;
        try {
            config = configs.properties(new File("src\\hogwarts\\webAuto\\POM\\data\\config.properties"));
            for (int i = 0; i < cookies.length; i++) {
                driver.manage().addCookie(new Cookie(cookies[i],config.getString(cookies[i])));
            }
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return true;
    }
}
