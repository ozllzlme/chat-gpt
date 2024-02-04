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
	"prompt_tokens",
	"completion_tokens",
	"total_tokens"
})

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usage {

	@JsonProperty("prompt_tokens")
	private Integer promptTokens;
	@JsonProperty("completion_tokens")
	private Integer completionTokens;
	@JsonProperty("total_tokens")
	private Integer totalTokens;
}