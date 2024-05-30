package com.spharos.kafkacomsumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

@SpringBootApplication
public class KafkacomsumerApplication {

	private static String TOPIC_NAME = "spharos-event";
	private static String BOOTSTRAP_SERVERS = "localhost:9092";
	private static String GROUP_ID = "kafka-consumer-group";

	public static void main(String[] args)
	{
		Properties configs = new Properties();
		configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
		configs.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID);
		configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(configs);
		consumer.subscribe(Arrays.asList(TOPIC_NAME));

		while(true) {
			// 1초에 한 덩어리 씩 가져오겠다.
			ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1));

			for (ConsumerRecord<String, String> record : records) {
				System.out.println("Received from producer > " + record.value());
			}
		}

//		SpringApplication.run(KafkacomsumerApplication.class, args);
	}

}
