package com.example.kafka.message;

import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


//@Component
public class KafkaMessageListener {

	@KafkaListener(
		topics = "my_kafka_topics",
		groupId="my_kafka_groupId",
		containerFactory="containerFactory"
	)
	public void performanceListener(List<String> messages) {
		for(int i=0; i<messages.size(); i++) {
			System.out.println(String.format("%s %s", (i+1), messages.get(i)));
		}
	}
	
}
