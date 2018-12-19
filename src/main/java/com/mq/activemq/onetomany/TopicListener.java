package com.mq.activemq.onetomany;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class TopicListener implements MessageListener {

    private final static TopicListener listener = new TopicListener();

    private TopicListener() {
    }

    public static TopicListener getListener() {
        return listener;
    }

    @Override
    public void onMessage(Message message) {
        TextMessage tm = (TextMessage) message;
        try {
            System.out.println(tm.getText());
        } catch (JMSException e) {
            e.printStackTrace();
            System.out.println("消费者读取内容失败！");
        }
    }
}
