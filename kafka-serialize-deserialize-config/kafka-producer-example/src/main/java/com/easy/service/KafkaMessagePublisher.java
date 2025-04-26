package com.easy.service;

import com.easy.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {

    @Autowired
    private KafkaTemplate<String,Object> KafkaTemplate;

    public void sendMessageToTopic(String message){

        CompletableFuture<SendResult<String, Object>> future = KafkaTemplate.send("easy-learning", message);
        future.whenComplete((result,ex) -> {

            if(ex == null){
                System.out.println("send message = " + message + " with offset = " + result.getRecordMetadata().offset() );
            }else{
                System.out.println("unable to send message = " + message + "due to " + ex.getMessage() );
            }
        });

    }

    public void sendEventsToTopic(Customer customer){
        try {
            CompletableFuture<SendResult<String, Object>> future = KafkaTemplate.send("easy-learning", customer);
            future.whenComplete((result,ex) -> {

                if(ex == null){
                    System.out.println("send message = " + customer.toString() + " with offset = " + result.getRecordMetadata().offset() );
                }else{
                    System.out.println("unable to send message = " + customer.toString() + "due to " + ex.getMessage() );
                }
            });
        }catch (Exception ex){

            System.out.println("Error : " + ex.getMessage());
        }
    }
}
