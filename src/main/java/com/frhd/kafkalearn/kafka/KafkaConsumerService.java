package com.frhd.kafkalearn.kafka;

import com.frhd.kafkalearn.model.User;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "my-topic", groupId = "my-group")
    public void listen(ConsumerRecord<String, String> record) {
        System.out.println("Received message: " + record.value());
    }
    // KafkaConsumerService.java
    @KafkaListener(topics = "user-topic", groupId = "my-group", containerFactory = "userKafkaListenerContainerFactory")
    public void consumeUser(User user) {
        System.out.println("📥 Received user: " + user.getName() + ", Age: " + user.getAge());
    }

}