//package com.blogsite.blog.service.config;
//
//import org.apache.kafka.clients.producer.KafkaProducer;
//import org.apache.kafka.clients.producer.Producer;
//import org.apache.kafka.clients.producer.ProducerRecord;
//import org.springframework.beans.factory.annotation.Value;
//
//import java.util.Properties;
//
//public class KafkaProducerConfig {
//    private static final String KAFKA_TOPIC = "blog-service-topic";
////    @Value("${spring.kafka.bootstrap-servers}")
//    private String BOOTSTRAP_SERVERS = "localhost:29092";
//
//    private final Producer<String, String> kafkaProducer;
//
//    public KafkaProducerConfig() {
//        Properties kafkaProps = new Properties();
//        kafkaProps.put("bootstrap.servers", BOOTSTRAP_SERVERS);
//        kafkaProps.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
//        kafkaProps.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
//        kafkaProducer = new KafkaProducer<>(kafkaProps);
//    }
//
//    public void sendLogToKafka(String logMessage) {
//        ProducerRecord<String, String> record = new ProducerRecord<>(KAFKA_TOPIC, logMessage);
//        kafkaProducer.send(record);
//    }
//}
