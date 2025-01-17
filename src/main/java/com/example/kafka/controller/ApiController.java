package com.example.kafka.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafka.response.ResponseTemplate;
import com.example.kafka.response.SendRequest;
import com.example.kafka.service.KafkaService;


@RestController
@RequestMapping("api")
public class ApiController {

	@Autowired
	private KafkaService kafkaService;

	@GetMapping("info")
	public ResponseTemplate info() {

		ResponseTemplate response = new ResponseTemplate();
		response.setStatus(1);
		response.setMessage("server is up");
		
		return response;
	}
	
	@PostMapping("send")
	public ResponseTemplate send(@RequestBody SendRequest request, @RequestParam(name = "size") Integer size) {
		
		for(int i=1; i<=size; i++) {
			Date start = new Date();
			String pesan = String.format("%s [%s]:%s", request.getMessage(), i, start.getTime());
			kafkaService.sendMessage(pesan);
		}

		ResponseTemplate response = new ResponseTemplate();
		response.setStatus(1);
		response.setMessage("success");
		response.setData(request.getMessage());
		
		return response;
	}

	
}
