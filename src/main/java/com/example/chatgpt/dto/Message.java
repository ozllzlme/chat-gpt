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
	"role",
	"content"
})

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

	@JsonProperty("role")
	private String role;
	@JsonProperty("content")
	private String content;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("role")
	public String getRole() {
		return role;
	}

	@JsonProperty("role")
	public void setRole(String role) {
		this.role = role;
	}

	@JsonProperty("content")
	public String getContent() {
		return content;
	}

	@JsonProperty("content")
	public void setContent(String content) {
		this.content = content;
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