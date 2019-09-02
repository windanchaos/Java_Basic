package middware.rocketmq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;

public class SyncProducer {
    public static void main(String[] args) throws MQClientException, UnsupportedEncodingException, RemotingException, InterruptedException, MQBrokerException {
        //实例化生产者producer
        DefaultMQProducer producer = new DefaultMQProducer("Test-SyncProducer");
        //设置nameserver地址
        producer.setNamesrvAddr("10.188.56.54:9876");
        //启动producer
        producer.start();
        //创建消息，并制定topic，tag和消息体
        for(int i=0;i<100;i++){
            Message msg = new Message("TopicTest001",
                    "TagA001",
                    ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            //发送消息到一个brokder
            SendResult sendResult = producer.send(msg);
            System.out.println(i+sendResult.getSendStatus().toString());
        }
        //如果不再发送消息，关闭producer实例
        producer.shutdown();
    }
}
