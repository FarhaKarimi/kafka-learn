package com.frhd.kafkalearn.kafka;

import com.frhd.kafkalearn.model.User;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private final KafkaTemplate<String, User> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    // KafkaProducerService.java
    public void sendUser(User user) {
        kafkaTemplate.send("user-topic", user);
        System.out.println("✅ Sent user to Kafka: " + user.getName());
    }

}
