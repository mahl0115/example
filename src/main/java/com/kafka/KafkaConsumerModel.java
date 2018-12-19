package com.kafka;

import com.google.common.collect.ImmutableMap;
import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.message.MessageAndMetadata;
import kafka.serializer.Decoder;
import kafka.serializer.StringDecoder;
import kafka.utils.VerifiableProperties;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by mahailong on 16/12/1.
 */
public class KafkaConsumerModel {

    Decoder<String> defaultDecoder = new StringDecoder(new VerifiableProperties());

    private static ConsumerConnector consumer;

    private static Map<String, Integer> topicCountMap = ImmutableMap.of(KafkaConstants.topic, 1);

    static {
        Properties props = new Properties();
        props.put("zookeeper.connect", KafkaConstants.zkConnect);
        props.put("group.id", KafkaConstants.groupId);
        props.put("serializer.class", KafkaConstants.default_serializer_class);

        ConsumerConfig config = new ConsumerConfig(props);
        consumer = Consumer.createJavaConsumerConnector(config);
    }

    /**
     *
     */
    private void consume() {

        Map<String, List<KafkaStream<String, String>>> createMessageStreams = consumer.createMessageStreams(topicCountMap, defaultDecoder, defaultDecoder);
        Iterator<String> iterator = createMessageStreams.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            List<KafkaStream<String, String>> values = createMessageStreams.get(key);
            for (KafkaStream<String, String> value : values) {
                ConsumerIterator<String, String> consumerIt = value.iterator();
                while (consumerIt.hasNext()) {
                    MessageAndMetadata<String, String> data = consumerIt.next();
                    System.out.println("The message is " + data.message());
                }
            }
        }

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        KafkaConsumerModel consumer = new KafkaConsumerModel();
        consumer.consume();
    }
}
