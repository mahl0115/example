//package com.mq.activemq.onetomany;
//
//import javax.jms.Connection;
//import javax.jms.ConnectionFactory;
//import javax.jms.JMSException;
//import javax.jms.MessageConsumer;
//import javax.jms.Session;
//import javax.jms.Topic;
//
//import org.apache.activemq.ActiveMQConnection;
//import org.apache.activemq.ActiveMQConnectionFactory;
//
//public class Receiver3 {
//
//    public static void main(String[] args) throws JMSException {
//        receive();
//    }
//
//    public static void receive() throws JMSException {
//        // 通过ActiveMQConnectionFactory创建到ActiveMQ的连接
//        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,
//                ActiveMQConnection.DEFAULT_PASSWORD, "tcp://localhost:61616");
//        Connection connection = connectionFactory.createConnection();
//        connection.start();
//        // 通过连接创建session,创建session有两个重要参数,如下：
//        // Boolean.TRUE表示采用事务，Boolean.FALSE表示不采用事务
//        // Session.AUTO_ACKNOWLEDGE表示session会自动确认所接收到的消息
//        // Session.CLIENT_ACKNOWLEDGE表示由客户端通过调用消息的确认方法来确认所收到的消息
//        // Session.DUPS_OK_ACKNOWLEDGE表示session将"懒惰"的确认消息,不会立即确认消息,这样可能导致消息重复投递
//        Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
//
//        // 通过session创建topic
//        Topic topic = session.createTopic("topic1");
//        // 根据topic创建消息的消费者
//        MessageConsumer consumer = session.createConsumer(topic);
//        consumer.setMessageListener(TopicListener.getListener());
//    }
//}
