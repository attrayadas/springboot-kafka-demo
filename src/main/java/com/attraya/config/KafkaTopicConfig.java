package com.attraya.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic attrayaTopic(){
        return TopicBuilder.name("attraya")
                .build();
    }

    // Seperate topic to send only the JSON messages
    @Bean
    public NewTopic attrayaJsonTopic(){
        return TopicBuilder.name("attraya_json")
                .build();
    }
}
