package middware.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

import static javax.jms.Session.AUTO_ACKNOWLEDGE;

public class QueueMessageConsumer {
    //地址
    private static final String ACTIVEMQ_URL = "tcp://116.62.220.247:61616";
    //定义队列名
    private static final String QUEUE_NAME = "Windanchaos";
    //定义发送消息的主题名称
    private static final String TOPIC_NAME = "MyTopicMessage";

    public static void main(String[] args) throws JMSException {
        //工厂对象
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("user_mkstar_prod_mq", "2017@mkstar_pr_mquser2", ACTIVEMQ_URL);
        //工厂对象创建连接对象
        Connection connection = activeMQConnectionFactory.createConnection();
        //打开连接
        try {
            connection.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //创建会话
        Session session = connection.createSession(false, AUTO_ACKNOWLEDGE);
        //创建队列目标
        Destination destination = session.createQueue(QUEUE_NAME);
        //创建消费者
        javax.jms.MessageConsumer consumer = session.createConsumer(destination);
        //创建topic目标
        Destination topicDestination = session.createTopic(TOPIC_NAME);
        //创建topic消费者
        javax.jms.MessageConsumer topicConsumer = session.createConsumer(topicDestination);
        //队列消费者监听线程
        new Thread() {
            public void run() {
                try {
                    consumer.setMessageListener(new MessageListener() {
                        @Override
                        public void onMessage(Message message) {
                            TextMessage textMessage = (TextMessage) message;
                            try {
                                System.out.println("获取消息：" + textMessage.getText());
                            } catch (JMSException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        //topic消费者监听线程
        new Thread() {
            public void run() {
                try {
                    topicConsumer.setMessageListener(new MessageListener() {
                        @Override
                        public void onMessage(Message message) {
                            TextMessage textMessage = (TextMessage) message;
                            try {
                                System.out.println("获取topic消息：" + textMessage.getText());
                            } catch (JMSException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        //connection.close();
    }
}
