package com.spring.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class KafkaApplication {
		private final  KafkaTemplate<String, String> kafkaTemplate;
	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);
	}



	//exercise to create kafka topic with 3 partitions. on the customer side, only 1 application, but it implements 3 kafka consumers with the same group.id properties
	// kafka assigns each consumer a different partition. his consumer gorup will receive the massages in load-balancer
	//producer json  kafka topic 3 partitions each partition to different consumer but same consumer group

	@GetMapping
	public String ok(){
		kafkaTemplate.send("code" , "hellow kafka");
		return  "OK";
	}
}
