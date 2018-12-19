//package com.mq.activemq.onetomany;
//
//import javax.jms.Connection;
//import javax.jms.ConnectionFactory;
//import javax.jms.DeliveryMode;
//import javax.jms.JMSException;
//import javax.jms.MessageProducer;
//import javax.jms.Session;
//import javax.jms.TextMessage;
//import javax.jms.Topic;
//
//import org.apache.activemq.ActiveMQConnection;
//import org.apache.activemq.ActiveMQConnectionFactory;
//
//public class Producer {
//
//    public static void main(String[] args) throws JMSException {
//        send();
//    }
//
//    public static void send() throws JMSException {
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
//        Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
//
//        // 根据session创建topic
//        Topic topic = session.createTopic("topic");
//
//        // 根据目的topic创建消息的生产者
//        MessageProducer producer = session.createProducer(topic);
//        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
//
//        TextMessage message = session.createTextMessage();
//        message.setText("message_hello_chenkangxian");
//        producer.send(message);
//        session.commit();
//        session.close();
//        connection.close();
//    }
//}
