package com.sample.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
	@Autowired
	Producer producer;
	
	@RequestMapping(value = "/publish")
    public String sendMessageToKafkaTopic(@RequestParam("message") String message,
    		@RequestHeader(value = "api-Key") String apiKeySentByCLient) {
		if(Constants.API_KEY.equals(apiKeySentByCLient)) {
			User user = new User(message, (int)(Math.random() * 100));
			producer.sendMessage(user);
			return "Message pushed on Kafka topic: " + user;
		}else {
			return "API key sent = " + apiKeySentByCLient + ". This is not a valid key";
		}
		
    }

}
