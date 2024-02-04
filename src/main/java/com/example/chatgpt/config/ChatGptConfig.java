package com.example.chatgpt.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration	//설정 파일을 만들기 위한 애노테이턴 or Bean을 등록하기 위한 애노테이션
public class ChatGptConfig {

	@Value("${gpt.secret-key}")
	private String gptKey;

	@Bean
	public RestTemplate template(){
		RestTemplate template =  new RestTemplate();
		template.getInterceptors().add(((request, body, execution) -> {
			request.getHeaders().add("Authorization","Bearer " + gptKey);
			return execution.execute(request,body);
		}));
		return template;
	}
}
