package middware.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.*;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;
import java.util.UUID;

public class Consumer {
    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer pushConsumer=new DefaultMQPushConsumer("ConsumerGroupTest01");
        //定义服务地址
        pushConsumer.setNamesrvAddr("10.188.56.53:9876");
        pushConsumer.subscribe("TopicTest001","*");
        pushConsumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
//        pushConsumer.registerMessageListener(new MessageListenerOrderly() {
//            @Override
//            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> list, ConsumeOrderlyContext consumeOrderlyContext) {
//                System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), list.size());
//                System.out.println(list.toString());
//                return ConsumeOrderlyStatus.SUCCESS;
//            }
//        });
        pushConsumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {

                System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), list);
                //System.out.println(list.toString());
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;

            }
        });
        pushConsumer.start();
        System.out.printf("Consumer Started.%n");
    }
}
