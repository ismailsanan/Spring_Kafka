package com.spring.kafka;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {
    @KafkaListener(topics = "code")
    public void listener(String data){

        System.out.println("Received: " + data );

    }

}
