package com.sample.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
	@Autowired
	Producer producer;
	
	@RequestMapping(value = "/publish")
    public String sendMessageToKafkaTopic(@RequestParam("message") String message) {
		producer.sendMessage(message);
		return "Message pushed on Kafka topic";
    }

}
