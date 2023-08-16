package com.attraya.controller;

import com.attraya.kafka.JsonKafkaProducer;
import com.attraya.payload.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

    private JsonKafkaProducer kafkaProducer;

    public JsonMessageController(JsonKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    // To get the topic: C:\Users\Attraya\Downloads\kafka>.\bin\windows\kafka-console-consumer.bat --topic attraya --from-beginning --bootstrap-server localhost:9092
    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user){
        kafkaProducer.sendMessage(user);
        return ResponseEntity.ok("JSON message sent to kafka topic");
    }
}
