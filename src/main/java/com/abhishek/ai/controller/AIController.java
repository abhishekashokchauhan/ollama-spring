package com.abhishek.ai.controller;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/ai")
public class AIController {

	@Autowired
	private OllamaChatModel chatModel;

	@GetMapping("/advanced")
	public Flux<ChatResponse> getResponse1(@RequestParam("prompt") String prompt) {
		Prompt promptOb = new Prompt(prompt);
		Flux<ChatResponse> response = chatModel.stream(promptOb);
		return response;

	}
	
	@GetMapping("/normal")
	public String getResponse2(@RequestParam("prompt") String prompt) {

		String response = chatModel.call(prompt);
		return response;

	}
}
