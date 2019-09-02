package middware.rocketmq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;

public class AsyncProducer {
    public static void main(String[] args) throws MQClientException, UnsupportedEncodingException, RemotingException, InterruptedException, MQBrokerException {
        //实例化生产者producer
        DefaultMQProducer producer = new DefaultMQProducer("Test-AsyncProducer");
        //设置nameserver地址
        producer.setNamesrvAddr("10.188.56.53:9876");
        //启动producer
        producer.start();
        producer.setRetryTimesWhenSendAsyncFailed(0);
        //创建消息，并制定topic，tag和消息体
        for(int i=0;i<100;i++){
            final int index=i;
            Message msg = new Message("TopicAsyncTest001",
                    "TagAsyncA001",
                    ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            //发送消息到一个brokder
            producer.send(msg, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.printf("%-10d OK %s %n", index,
                            sendResult.getMsgId());
                }

                @Override
                public void onException(Throwable e) {
                    System.out.printf("%-10d Exception %s %n", index, e);
                    e.printStackTrace();
                }
            });
        }
        //如果不再发送消息，关闭producer实例
        //producer.shutdown();
    }
}
