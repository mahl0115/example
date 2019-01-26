package com.mq.activemq.onotoone;//package com.mq.activemq.onotoone;
//
//import javax.jms.Connection;
//import javax.jms.ConnectionFactory;
//import javax.jms.Destination;
//import javax.jms.JMSException;
//import javax.jms.Message;
//import javax.jms.MessageConsumer;
//import javax.jms.ObjectMessage;
//import javax.jms.Session;
//
//import org.apache.activemq.ActiveMQConnection;
//import org.apache.activemq.ActiveMQConnectionFactory;
//
//public class Receiver {
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
//        Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
//        // 通过session创建一个queue,消息的发送者会向这个queue
//        Destination destination = session.createQueue("MessageQueue");
//        // 根据目的queue创建消息的生产者
//        MessageConsumer consumer = session.createConsumer(destination);
//        while (true) {
//            // 取出消息
//            Message message = consumer.receive();
//            if (message != null) {
//                ObjectMessage objMessage = (ObjectMessage) message;
//                String messageContent = (String) objMessage.getObject();
//                System.out.println(messageContent);
//            }
//
//        }
//    }
//}
