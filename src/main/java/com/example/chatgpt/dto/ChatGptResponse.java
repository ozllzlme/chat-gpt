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
	"id",
	"object",
	"created",
	"model",
	"choices",
	"usage",
	"system_fingerprint"
})

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatGptResponse {

	@JsonProperty("id")
	private String id;
	@JsonProperty("object")
	private String object;
	@JsonProperty("created")
	private Integer created;
	@JsonProperty("model")
	private String model;
	@JsonProperty("choices")
	private List<Choice> choices;
	@JsonProperty("usage")
	private Usage usage;
	@JsonProperty("system_fingerprint")
	private Object systemFingerprint;
}