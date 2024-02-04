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
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("model")
	public String getModel() {
		return model;
	}

	@JsonProperty("model")
	public void setModel(String model) {
		this.model = model;
	}

	@JsonProperty("messages")
	public List<Message> getMessages() {
		return messages;
	}

	@JsonProperty("messages")
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	@JsonProperty("temperature")
	public Integer getTemperature() {
		return temperature;
	}

	@JsonProperty("temperature")
	public void setTemperature(Integer temperature) {
		this.temperature = temperature;
	}

	@JsonProperty("max_tokens")
	public Integer getMaxTokens() {
		return maxTokens;
	}

	@JsonProperty("max_tokens")
	public void setMaxTokens(Integer maxTokens) {
		this.maxTokens = maxTokens;
	}

	@JsonProperty("top_p")
	public Integer getTopP() {
		return topP;
	}

	@JsonProperty("top_p")
	public void setTopP(Integer topP) {
		this.topP = topP;
	}

	@JsonProperty("frequency_penalty")
	public Integer getFrequencyPenalty() {
		return frequencyPenalty;
	}

	@JsonProperty("frequency_penalty")
	public void setFrequencyPenalty(Integer frequencyPenalty) {
		this.frequencyPenalty = frequencyPenalty;
	}

	@JsonProperty("presence_penalty")
	public Integer getPresencePenalty() {
		return presencePenalty;
	}

	@JsonProperty("presence_penalty")
	public void setPresencePenalty(Integer presencePenalty) {
		this.presencePenalty = presencePenalty;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}