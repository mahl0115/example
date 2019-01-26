package com.kafka;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by mahailong on 16/12/1.
 */
public class KafkaProducerModel {

    private static Producer<String, String> procuder;

    static {
        Properties props = new Properties();
        props.put("metadata.broker.list", KafkaConstants.kafkaServer);
        props.put("serializer.class", KafkaConstants.default_serializer_class);
        props.put("request.required.acks", KafkaConstants.request_required_acks);
        ProducerConfig config = new ProducerConfig(props);
        procuder = new Producer<String, String>(config);
    }


    /**
     */
    private void produce() throws InterruptedException {
        int num = 0;
        while (true) {

            KeyedMessage<String, String> msg = new KeyedMessage<String, String>(KafkaConstants.topic, "value_" + num);
            procuder.send(msg);

            num++;

            TimeUnit.SECONDS.sleep(1);
        }

        //procuder.close();
    }

    /**
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {

        KafkaProducerModel producer = new KafkaProducerModel();
        producer.produce();
    }
}
