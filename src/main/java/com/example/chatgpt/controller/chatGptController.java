package com.example.chatgpt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.chatgpt.dto.ChatGptRequest;
import com.example.chatgpt.dto.ChatGptResponse;
import com.example.chatgpt.dto.Message;

@RestController
public class chatGptController {

	@Autowired
	private RestTemplate template;


	@Value("${gpt.model}")
	private String model ;

	@Value("${gpt.url}")
	private String url;

	@GetMapping("/gpt/{prompt}")
	public ChatGptResponse getChatGptResponse(@PathVariable("prompt") String prompt){
		ChatGptRequest request = new ChatGptRequest();
		List<Message> messageList = new ArrayList<>();
		Message chatGptMessage = new Message();
		chatGptMessage.setRole("user");
		chatGptMessage.setContent(prompt);
		messageList.add(chatGptMessage);
		request.setModel(model);
		request.setMessages(messageList);

		ChatGptResponse chatGptResponse = template.postForObject(url,request,ChatGptResponse.class);
		return chatGptResponse;
	}
}
