import org.junit.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.given;

public class XueQiuDemo {
    @Test
    public void testGet(){
        //https://xueqiu.com/statuses/search.json?sort=relevance&source=all&q=%E6%8B%BC%E5%A4%9A%E5%A4%9A&count=10&page=1
        HashMap<String,String> params=new HashMap();
        params.put("sort","relevance");
        params.put("source","all");
        params.put("q","拼多多");
        params.put("page","1");
        String cookies="acw_tc=2760821715773275537581038ed05ca978fef40b3ae5f70385c90f2148580f; device_id=24700f9f1986800ab4fcc880530dd0ed; aliyungf_tc=AQAAAJ6RzGwciAoA73RGfazKL7Ewa/YU; xq_a_token=c9d3b00a3bd89b210c0024ce7a2e049f437d4df3; xq_r_token=8712d4cae3deaa2f3a3d130127db7a20adc86fb2; u=761577783773897; Hm_lvt_1db88642e346389874251b5a1eded6e3=1577327736,1577760685,1577762354,1577783774; Hm_lpvt_1db88642e346389874251b5a1eded6e3=1577783774";
        given().params(params).cookie(cookies)
                .get("https://xueqiu.com/statuses/search.json")
                .then()
                .log().all()
                .statusCode(200);

    }

}
