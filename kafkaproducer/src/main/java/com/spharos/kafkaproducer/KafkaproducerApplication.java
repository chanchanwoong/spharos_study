package com.spharos.kafkaproducer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

@SpringBootApplication
public class KafkaproducerApplication {

    // 환경 변수 설정
    private static String TOPIC_NAME = "spharos-event";
    private static String BOOTSTRAP_SERVERS = "localhost:9092";
    private static int PARTITIONS_NUMBER = 1;

    public static void main(String[] args) {
        Properties configs = new Properties();

        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        KafkaProducer<String, String> producer = new KafkaProducer<>(configs);

        for (int i = 0; i < 10; i++) {
            ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC_NAME, "Hello. Kafka " + i);
			try {
				producer.send(record);
				System.out.println("Send to Consumer : " + record.value());
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println(e);
			}
        }

//        SpringApplication.run(KafkaproducerApplication.class, args);
    }

}
