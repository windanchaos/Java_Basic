package frame;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.JexlExpression;
import org.apache.commons.jexl3.MapContext;
import org.apache.commons.jexl3.internal.Engine;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class AppBase {
    public static AndroidDriver driver;
    public static ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

    private By messageID = By.id("com.maike51.xke:id/lay_home_tab_message");
    private By CRMID = By.id("com.maike51.xke:id/lay_home_tab_client");
    private By workstationID = By.id("com.maike51.xke:id/lay_home_tab_work");
    private By mineID = By.id("com.maike51.xke:id/lay_home_tab_mine");
    public static AppBase appBase;

    public AppBase() {
        //保证只有一个实例和driver存在
        if (null == appBase && null == appBase.driver) {
            AppBase.initApp(null);
        }
    }

    //直接启动activity
    public AppBase(String appActivity) {
        //保证只有一个实例和driver存在
        if (appBase == null && null == appBase.driver) {
            AppBase.initApp(appActivity);
        }
    }

    public static void initApp(String appActivity) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("deviceName", "127.0.0.1:7555");
        desiredCapabilities.setCapability("appPackage", "com.maike51.xke");
        if (null == appActivity)
            desiredCapabilities.setCapability("appActivity", ".home.ui.HomeActivity");
        else
            desiredCapabilities.setCapability("appActivity", appActivity);
        desiredCapabilities.setCapability("noReset", "true");
        URL remoteUrl = null;
        try {
            remoteUrl = new URL("http://localhost:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }

    //元素click封装
    public static void click(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        WebElement element = wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver d) {
                return d.findElement(by);
            }
        });
        element.click();
        //应对连续点击的情况
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //元素定位封装
    public static void sendkeys(By by, String key) {
        if (driver.findElement(by).getAttribute("class").toString().contains("EditText"))
            driver.findElement(by).clear();
        driver.findElement(by).sendKeys(key);
    }

    /**
     * 滑屏查找元素
     *
     * @param checker 标记结束标记，现在是以文本来区分，当checker的元素在滑动后不再变动则停止滑动。
     * @param element 要查找的元素
     */
    public static boolean scrollFindElement(By checker, By element) {
        String firstElement = driver.findElement(checker).getText();
        try {
            if (driver.findElement(element).isEnabled())
                return true;
        } catch (Exception e) {
            System.out.println("element" + element.toString() + "can not be found，will scroll again");
        }
        srollUp();
        if (driver.findElement(checker).getText().equals(firstElement)) {
            return false;
        } else
            return scrollFindElement(checker, element);
    }

    //滑屏

    public static void srollUp() {
        srollY(0.5f, 0.5f, 0.65f, 0.25f);
    }

    public static void srollDown() {
        srollY(0.5f, 0.5f, 0.25f, 0.65f);
    }

    public static void srollLeft() {
        srollY(0.9f, 0.5f, 0.5f, 0.5f);
    }

    public static void srollRight() {
        srollY(0.5f, 0.9f, 0.5f, 0.5f);
    }

    public static void srollY(float Xstart, float Xend, float Ystart, float Yend) {
        int width = driver.manage().window().getSize().width;//获取当前屏幕的宽度
        int height = driver.manage().window().getSize().height;//获取当前屏幕的高度
        TouchAction<AndroidTouchAction> tAction = new AndroidTouchAction(driver);
        tAction.press(PointOption.point((int) (width * Xstart), (int) (height * Ystart)))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point((int) (width * Xend), (int) (height * Yend)))
                .release()
                .perform();
    }

    /*
    解析配置文件中的定位元素，返回HashMap
     */
    public HashMap<String, By> getElementsByConfig() {
        //暂时放在test的resource目录，后期拆分，要单独拿出去
        String configPath = this.getClass().getClassLoader().getResource(".").getPath()
                + "Elements.yaml";
        //使用snakeYaml来解析
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("Elements.yaml");
        //hashmap定义文档结构
        HashMap<String, HashMap<String, HashMap<String, String>>> configMaps = yaml.load(inputStream);
        HashMap<String, By> elementMaps = new HashMap<>();
        HashMap<String, HashMap<String, String>> configMap = configMaps.get(this.getClass().getSimpleName());
        configMap.entrySet().forEach(stringHashMapEntry -> {
            if (null != stringHashMapEntry.getValue()) {
                stringHashMapEntry.getValue().entrySet().forEach(stringStringEntry -> {
                    if (stringStringEntry.getKey().equals("By.ViewText")
                            && null != stringStringEntry.getValue()
                            && null != stringHashMapEntry.getKey()) {
                        elementMaps.put(stringHashMapEntry.getKey(),
                                CommonTools.TextViewXpathTextGenerator(stringStringEntry.getValue()));
                    }
                    if (stringStringEntry.getKey().equals("By.id")
                            && null != stringStringEntry.getValue()
                            && null != stringHashMapEntry.getKey()) {
                        elementMaps.put(stringHashMapEntry.getKey(),
                                By.id(stringStringEntry.getValue()));
                    }
                    if (stringStringEntry.getKey().equals("By.xpath")
                            && null != stringStringEntry.getValue()
                            && null != stringHashMapEntry.getKey()) {
                        elementMaps.put(stringHashMapEntry.getKey(),
                                By.xpath(stringStringEntry.getValue()));
                    }
                });
            }
        });

        return elementMaps;
    }

    /*
    处理元素替换关键字。思路：替换String中的关键字，把String转成可执行代码来实现
     */
    public By replaceKey(By by, String oldkey, String newKey) {
        String method = by.toString().split(": ")[0];
        String location = by.toString().split(": ")[1].replace("${" + oldkey + "}", newKey);
        //表达式，表达式可以是数组的属性，元素等
        String expressionStr = "newBy=" + method + "(\"" + location + "\")";
        JexlEngine engine = new Engine();//创建表达式引擎对象
        JexlContext context = new MapContext();//创建Context设值对象
        By newBy = null;
        context.set("newBy", newBy);
        context.set("By", By.class);
        //使用引擎创建表达式对象
        JexlExpression expression = engine.createExpression(expressionStr);
        //使用表达式对象开始计算
        Object object = expression.evaluate(context);
        return (By) object;
    }

    /*
    PO传参数
     */
    private HashMap<Object, Object> parameters;
    private static HashMap<String, Object> results = new HashMap<>();

    public static HashMap<String, Object> getResults() {
        return results;
    }

    public HashMap<Object, Object> getParameters() {
        return parameters;
    }

    public void setParameter(Object key, Object value) {
        this.parameters.put(key, value);
    }


    //PO的方法的数据驱动解析
    public void parseSteps() {
        //获取当前方法的调用者，即PO的方法
        String method = Thread.currentThread().getStackTrace()[2].getMethodName();
        //获取当前类名，以取得yaml的文件名，这里定义：类型和yaml文件同名。
        String yamlName = this.getClass().getSimpleName() + ".yaml";
        String yamlPath = this.getClass().getClassLoader().getResource(".").getPath() + yamlName;
        File yamlFile = null;
        HashMap<String, ArrayList<HashMap<String, String>>> methodsBody = null;
        try {
            yamlFile = new File(yamlPath);
            methodsBody = mapper.readValue(yamlFile,
                    new TypeReference<HashMap<String, ArrayList<HashMap<String, String>>>>() {
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList<HashMap<String, String>> methodbody = methodsBody.get(method);
        for (HashMap<String, String> map : methodbody) {
            map.entrySet().forEach(stringEntry -> {
                action(stringEntry.getKey(), stringEntry.getValue());
            });
        }

    }

    //执行解析到的数据，XKMethods中定义的方法，顾名思义
    //如需传参数，要PO中调用setparmeter提供
    public void action(String step, String elementLocation) {
        if (step.equals(AppMethod.FindXpathClick.name())) {
            click(By.xpath(elementLocation));
        }
        if (step.equals(AppMethod.FindIDClick.name())) {
            click(By.id(elementLocation));
        }
        if (step.equals(AppMethod.SendKeys.name())) {
            sendkeys(By.xpath(elementLocation), (String) parameters.get("key"));
        }
        if (step.equals(AppMethod.ScrollFindXpath.name())) {
            //找元素目前只写了xpath，理论上应该是hashmap传进来的by。
            scrollFindElement(By.xpath((String) parameters.get("checker")), By.xpath(elementLocation));
        }
        if (step.equals(AppMethod.ScrollFindID.name())) {
            //找元素目前只写了xpath，理论上应该是hashmap传进来的by。
            scrollFindElement(By.id((String) parameters.get("checker")), By.xpath((String) parameters.get("finder")));
        }
    }

}
