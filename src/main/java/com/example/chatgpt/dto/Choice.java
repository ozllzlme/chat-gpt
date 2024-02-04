package com.example.chatgpt.dto;

import java.util.LinkedHashMap;
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
	"index",
	"message",
	"logprobs",
	"finish_reason"
})

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Choice {

	@JsonProperty("index")
	private Integer index;
	@JsonProperty("message")
	private Message message;
	@JsonProperty("logprobs")
	private Object logprobs;
	@JsonProperty("finish_reason")
	private String finishReason;
}