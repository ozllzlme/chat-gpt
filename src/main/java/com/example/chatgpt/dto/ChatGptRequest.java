package com.example.chatgpt.dto;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"model",
	"messages",
	"temperature",
	"max_tokens",
	"top_p",
	"frequency_penalty",
	"presence_penalty"
})

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatGptRequest {

	@JsonProperty("model")
	private String model;
	@JsonProperty("messages")
	private List<Message> messages;
	@JsonProperty("temperature")
	private Integer temperature;
	@JsonProperty("max_tokens")
	private Integer maxTokens;
	@JsonProperty("top_p")
	private Integer topP;
	@JsonProperty("frequency_penalty")
	private Integer frequencyPenalty;
	@JsonProperty("presence_penalty")
	private Integer presencePenalty;
}