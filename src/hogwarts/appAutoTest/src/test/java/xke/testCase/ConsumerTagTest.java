package xke.testCase;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import xke.po.crm.ConsumerTag;

public class ConsumerTagTest {
    public static ConsumerTag consumerTag;

    @BeforeAll
    public static void setUp() {
        consumerTag = new ConsumerTag(true);
    }

    @Test
    public void chooseConsumerTest() {
        consumerTag.createAndAddconsumer("京东热", "石原里美");
    }

}
