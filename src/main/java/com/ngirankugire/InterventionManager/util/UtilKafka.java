// /*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
// package com.parika.util;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.kafka.core.KafkaTemplate;
// import org.springframework.kafka.support.SendResult;
// import org.springframework.stereotype.Component;
// import org.springframework.util.concurrent.ListenableFuture;

// import java.util.concurrent.ExecutionException;

// /**
//  *
//  * @author Aubain
//  */
// @Component
// public class UtilKafka {
//     public static enum TOPIC{PUBLISH_SEARCH_RECORD};
//     @Autowired
//             KafkaTemplate<String, String> kafkaTemplate;
//     public String publish(String topic, String payLoad) throws InterruptedException, ExecutionException{
//         ListenableFuture<SendResult<String, String>> result = kafkaTemplate.send(topic, payLoad);
//         return result.get().getProducerRecord().value();
//     }
    
//     /*@KafkaListener(topics = { "test" })
//     public void listen(@RequestBody String payload) {
//         System.out.println("Kafka event consumed is: " + payload);
//     }*/
// }
