package com.sunny.blog.mq.activemq.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author sunny
 * @className ActivemqProducer
 * @date 2018-02-08 17:21
 * @description: 队列模式的mq
 */
public class ActivemqProducer {

    private static final String url = "tcp://127.0.0.1:61616";

    private static final String queueName = "queue-test";

    public static void main(String[] args) throws JMSException {
        //1.创建connectionFactory
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);

        // 2. 创建connection
        Connection connection = connectionFactory.createConnection();

        // 3. 启动连接
        connection.start();

        // 创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // 创建一个队列
        Destination destination = session.createQueue(queueName);

        // 创建生产者
        MessageProducer producer = session.createProducer(destination);

        for (int i = 0; i < 100; i++) {
            // 创建消息
            TextMessage textMessage = session.createTextMessage("test:" + i);
            //发送消息
            producer.send(textMessage);

            System.out.println("发送消息：" + textMessage.getText());
        }
        // 关闭连接
        connection.close();
    }

}
