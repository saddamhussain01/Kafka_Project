package com.easy.controller;

import com.easy.dto.Customer;
import com.easy.service.KafkaMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer-app")
public class EventController {

    @Autowired
    private KafkaMessagePublisher kafkaMessagePublisher;


    @GetMapping("/publish/{message}")
    public ResponseEntity<?> publishMessage(@PathVariable String message){
        try {
            for (int i=0;i<=10000;i++){

                kafkaMessagePublisher.sendMessageToTopic(message + " : " + i);

            }
            return  ResponseEntity.ok("message successfully published");
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/publish")
    public void publishEvent(@RequestBody Customer customer){
        kafkaMessagePublisher.sendEventsToTopic(customer);
    }
}
