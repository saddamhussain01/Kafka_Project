package com.easy.consumer;

import com.easy.dto.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerListener {

    Logger logger = LoggerFactory.getLogger(KafkaConsumerListener.class);

    @KafkaListener(topics = "easy-learning", groupId = "easy-group")
    public void consume1(Customer customer){

        logger.info("consumer consume the message {} ", customer.toString());

    }

//    @KafkaListener(topics = "easy-learning-topic1", groupId = "easy-group-2")
//    public void consume2(String message){
//
//        logger.info("consumer2 consume the message {} ", message);
//
//    }
//
//    @KafkaListener(topics = "easy-learning-topic1", groupId = "easy-group-2")
//    public void consume3(String message){
//
//        logger.info("consumer3 consume the message {} ", message);
//
//    }
//
//    @KafkaListener(topics = "easy-learning-topic1", groupId = "easy-group-2")
//    public void consume4(String message){
//
//        logger.info("consumer4 consume the message {} ", message);
//
//    }
}
