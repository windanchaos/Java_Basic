package xke.testCase;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.yaml.snakeyaml.Yaml;
import xke.po.crm.ConsumerClaim;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ConsumerClaimTest {
    public static ConsumerClaim claim;

    @BeforeAll
    public static void setUp() {
        //claim=new ConsumerClaim(true);
    }

    @Test
    @Order(1)
    public void claimTest() {
        claim.claim("十元");
    }

    @Test
    @Order(2)
    public void searchTest() {
        claim.unclaimTab();
        claim.search("十元");
        claim.claimedTab();
        claim.search("小苹果");
    }

    @Test
    public void test3() {
        //printMap();
        getElementsByConfig();
        //snakeYamlTest();
    }

    public HashMap<String, By> getElementsByConfig() {

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        //mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        String configPath = this.getClass().getClassLoader().getResource(".").getPath()
                + "Elements2.yaml";
        HashMap<String, HashMap<String, HashMap<String, String>>> configMaps;
        HashMap<String, By> elementMaps = null;
        try {
            configMaps = mapper.readValue(configPath,
                    new TypeReference<HashMap<String, HashMap<String, HashMap<String, String>>>>() {
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void snakeYamlTest() {
        String configPath = this.getClass().getClassLoader().getResource(".").getPath()
                + "Elements.yaml";
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("Elements.yaml");
        HashMap<String, Map<String, Map<String, String>>> configMaps = yaml.load(inputStream);
        System.out.println(configMaps.size());
        configMaps.entrySet().forEach(stringMapEntry -> {
            System.out.println(stringMapEntry.getKey() + ": ");
            stringMapEntry.getValue().entrySet().forEach(stringMapEntry1 -> {
                System.out.println("  " + stringMapEntry1.getKey() + ": ");
                stringMapEntry1.getValue().entrySet().forEach(stringStringEntry -> {
                    System.out.println("    " + stringStringEntry.getKey() + ": " + stringStringEntry.getValue());
                });
            });
        });
    }

    public static void printMap() {
        //顶层
        HashMap<String, HashMap<String, HashMap<String, String>>> configMaps = new HashMap<>();
        //第一层
        HashMap<String, HashMap<String, String>> claim = new HashMap<>();
        HashMap<String, HashMap<String, String>> info = new HashMap<>();
        HashMap<String, HashMap<String, String>> tag = new HashMap<>();
        //第二层
        HashMap<String, String> elementMaps1 = new HashMap<>();
        HashMap<String, String> elementMaps2 = new HashMap<>();
        HashMap<String, String> elementMaps3 = new HashMap<>();
        elementMaps1.put("By.ViewText", "未认领");
        elementMaps2.put("By.ViewText", "已认领");
        elementMaps3.put("By.id", "com.maike51.xke:id/search_view");

        claim.put("unclaim", elementMaps1);
        claim.put("claimed", elementMaps2);
        claim.put("search", elementMaps3);

        configMaps.put("ConsumerClaim", claim);
        configMaps.put("ConsumerInfo", info);
        configMaps.put("ConsumerTag", tag);
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(configMaps));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


    }
}
