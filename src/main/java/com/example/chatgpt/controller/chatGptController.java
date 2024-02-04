package com.example.chatgpt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.chatgpt.dto.ChatGptRequest;
import com.example.chatgpt.dto.ChatGptResponse;
import com.example.chatgpt.dto.Message;

import reactor.core.publisher.Mono;

@RestController
public class chatGptController {

	@Autowired
	private WebClient webClient;


	@Value("${gpt.model}")
	private String model ;

	@Value("${gpt.url}")
	private String url;

	@GetMapping("/gpt/{prompt}")
	public Mono<ChatGptResponse> getChatGptResponse(@PathVariable("prompt") String prompt){
		ChatGptRequest request = new ChatGptRequest();
		List<Message> messageList = new ArrayList<>();
		Message chatGptMessage = new Message();
		chatGptMessage.setRole("user");
		chatGptMessage.setContent(prompt);
		messageList.add(chatGptMessage);
		request.setModel(model);
		request.setMessages(messageList);

		return webClient.post()
			.uri(url)
			.contentType(MediaType.APPLICATION_JSON)
			.bodyValue(request)
			.retrieve()
			.bodyToMono(ChatGptResponse.class);
	}
}
