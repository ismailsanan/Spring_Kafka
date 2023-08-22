package com.spring.kafka;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);
	}



	//exercise to create kafka topic with 3 partitions. on the customer side, only 1 application, but it implements 3 kafka consumers with the same group.id properties
	// kafka assigns each consumer a different partition. his consumer gorup will receive the massages in load-balancer
	//producer json  kafka topic 3 partitions each partition to different consumer but same consumer group

	@Bean
	CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate){
		return args -> {

			kafkaTemplate.send("code" , "hellow kafka");


		};
	}
}
