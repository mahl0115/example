package com.kafka;

/**
 * Created by mahailong on 16/12/1.
 */
public class KafkaConstants {

    public static final String zkConnect = "127.0.0.1:2181";
    public static final String groupId = "group1";
    public static final String topic = "topic1";
    public static final String kafkaServer = "127.0.0.1:9091";
    public static final int kafkaProducerBufferSize = 64 * 1024;
    public static final int connectionTimeOut = 20000;
    public static final int reconnectInterval = 10000;
    public static final String topic2 = "topic2";
    public static final String topic3 = "topic3";
    public static final String clientId = "SimpleConsumerDemoClient";
    public static final String default_serializer_class = "kafka.serializer.StringEncoder";
    public static final String request_required_acks = "0";
}
