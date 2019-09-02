package middware.activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.leveldb.replicated.MasterLevelDBStore;

import javax.jms.*;

import static javax.jms.Session.AUTO_ACKNOWLEDGE;

public class QueueMessgeProducer {
    //地址
    private static final String ACTIVEMQ_URL="tcp://116.62.220.247:61616";
    //定义队列名
    private static final String QUEUE_NAME="Windanchaos";
    //定义发送消息的主题名称
    private static final String TOPIC_NAME = "MyTopicMessage";

    public static void main(String[] args) throws JMSException {
        //工厂对象
        ActiveMQConnectionFactory activeMQConnectionFactory=new ActiveMQConnectionFactory("user_mkstar_prod_mq","2017@mkstar_pr_mquser2",ACTIVEMQ_URL);
        //工厂对象创建连接对象
        Connection connection= activeMQConnectionFactory.createConnection();
        //打开连接
        try {
            connection.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //创建会话
        Session session=connection.createSession(false,AUTO_ACKNOWLEDGE);
        //创建队列目标
        Destination destination=session.createQueue(QUEUE_NAME);
        //创建queue生产者
        javax.jms.MessageProducer producer=session.createProducer(destination);
        //异步创建创建queue生产者消息
        new Thread(){
            public void run(){
                for(int i=0;i<100;i++){
                    TextMessage message= null;
                    try {
                        message = session.createTextMessage("发送消息编号："+i);
                        //发送消息
                        producer.send(message);
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }

                }
            }
        }.start();

        //创建topic目标
        Destination topicDestination=session.createTopic(TOPIC_NAME);
        //异步创建topic生产者
        javax.jms.MessageProducer topic_messgProducer=session.createProducer(topicDestination);
        new Thread(){
            public void run(){
                for(int i=0;i<100;i++){
                    TextMessage message= null;
                    try {
                        message = session.createTextMessage("Topic消息编号："+i);
                        //发送消息
                        topic_messgProducer.send(message);
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }

                }
            }
        }.start();
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        connection.close();


    }
}
