package wework;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
/*
数据驱动基类
业务类继承该类，获取读取配置文件的能力,yaml反序列化成对象
 */
public class DataDriveBase {

    public HashMap<String,Object> templateParameters;
    //返回接口的hashmap
    public HashMap<String,RequestModel> deSerialize(){
        HashMap<String,RequestModel> apis = new HashMap<>();
        RequestModel requestModel = new RequestModel();
        //从堆栈中获取上层调用的方法
        String method = Thread.currentThread().getStackTrace()[2].getMethodName();
        String yamlPath = "/"+this.getClass().getCanonicalName().replace('.','/')+".yaml";
        System.out.println(method);
        System.out.println(yamlPath);
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            apis = mapper.readValue(
                    DataDriveBase.class.getResourceAsStream(yamlPath),new TypeReference<HashMap<String,RequestModel>>() {
                    }
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return apis;
    }
}
