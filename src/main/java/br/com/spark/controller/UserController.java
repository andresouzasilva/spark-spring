package br.com.spark.controller;

import static spark.Spark.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.spark.helper.JsonTransformer;
import br.com.spark.service.UserService;

@Component
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JsonTransformer jsonTransformer;
	
	public void init(){
		get("/hello", (request, response) -> {
			return userService.getHelloWorld();
		}, jsonTransformer);
	}
}
