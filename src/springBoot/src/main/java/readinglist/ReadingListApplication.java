package readinglist;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 开启组件扫描和自动配置
 * 实际上把Spring的@Configuration @ComponentScan @EnableAutoConfiguration组合在一起了
 */
@SpringBootApplication
public class ReadingListApplication {
    public static void main(String[] args) {
        //负责启动引导应用程序
        SpringApplication.run(ReadingListApplication.class,args);
    }

}
