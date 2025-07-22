package com.frhd.kafkalearn.controller;

import com.frhd.kafkalearn.kafka.KafkaProducerService;
import com.frhd.kafkalearn.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/message")
public class MessageController {

    private final KafkaProducerService kafkaProducerService;

    public MessageController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }


    // MessageController.java
    @PostMapping("/user")
    public String sendUser(@RequestBody User user) {
        kafkaProducerService.sendUser(user);
        return "✅ User sent!";
    }

}
