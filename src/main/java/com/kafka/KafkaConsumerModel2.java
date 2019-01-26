package com.kafka;

import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by mahailong on 16/12/1.
 */
public class KafkaConsumerModel2 {

    private final ConsumerConnector consumer;
    private final String topic;

    public KafkaConsumerModel2(String topic) {
        consumer = kafka.consumer.Consumer.createJavaConsumerConnector(
                createConsumerConfig());
        this.topic = topic;
    }

    private static ConsumerConfig createConsumerConfig() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9091,localhost:9092,localhost:9093");
        props.put("zookeeper.connect", KafkaConstants.zkConnect);
        props.put("group.id", KafkaConstants.groupId);
        props.put("zookeeper.session.timeout.ms", "30000");
        props.put("zookeeper.sync.time.ms", "200");
        props.put("rebalance.backoff.ms", "2000");
        props.put("rebalance.max.retries", "20");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "60000");
        return new ConsumerConfig(props);
    }

    public void consume() {
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(new Runnable() {
            public void run() {
                Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
                topicCountMap.put(topic, new Integer(1));
                Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumer.createMessageStreams(topicCountMap);
                KafkaStream<byte[], byte[]> stream = consumerMap.get(topic).get(0);
                ConsumerIterator<byte[], byte[]> it = stream.iterator();
                while (it.hasNext()) {
                    System.out.println(new String(it.next().message()) + " Me too 1");
//                    try {
//                        Thread.sleep(3000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
            }
        });
    }
}
