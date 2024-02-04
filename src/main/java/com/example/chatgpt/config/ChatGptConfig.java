package com.example.chatgpt.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration	//설정 파일을 만들기 위한 애노테이턴 or Bean을 등록하기 위한 애노테이션
public class ChatGptConfig {

	@Value("${gpt.secret-key}")
	private String gptKey;

	@Value("${gpt.url}")
	private String url;

	@Bean
	public WebClient.Builder webClientBuilder(){
		return WebClient.builder()
			.baseUrl(url)
			.clientConnector(new ReactorClientHttpConnector())
			.defaultHeader(HttpHeaders.AUTHORIZATION,"Bearer " + gptKey);

	}

	@Bean WebClient webClient(WebClient.Builder webClientBuilder){
		return webClientBuilder.build();
	}
}
