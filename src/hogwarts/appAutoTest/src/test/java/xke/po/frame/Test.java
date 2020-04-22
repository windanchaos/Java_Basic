package xke.po.frame;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.getInfo("hahahahaahaha");
    }

    public void getInfo(String basdd) {
        parseSteps();
    }

    //PO的方法的数据驱动解析
    public void parseSteps() {
        //获取当前方法的调用者，即PO的方法
        String method = Thread.currentThread().getStackTrace()[2].getMethodName();
        //System.out.println(method);
        //获取PO的方法中参数和值
        Method[] methods = Thread.currentThread().getStackTrace()[2].getClassName().getClass().getMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i].getName());
        }
        //System.out.println(Thread.currentThread().getStackTrace()[2].getClassName().getClass().getMethods().length);

        //获取当前类名，以取得yaml的文件名，这里定义：类型和yaml文件同名。
        String yamlName = this.getClass().getSimpleName() + ".yaml";
        String yamlPath = this.getClass().getClassLoader().getResource(".").getPath() + yamlName;
        File yamlFile = null;
        HashMap<String, ArrayList<HashMap<String, String>>> methodsBody = null;
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
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
                System.out.println(stringEntry.getKey());
                System.out.println(stringEntry.getValue());
            });
        }
    }
}

