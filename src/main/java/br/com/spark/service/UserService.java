package br.com.spark.service;

import org.springframework.stereotype.Component;

import com.google.gson.JsonObject;

@Component
public class UserService {
	
	public JsonObject getHelloWorld(){
		JsonObject response = new JsonObject();
		response.addProperty("message", "Hello World!");
		return response;
	}
}
