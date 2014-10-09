package br.com.spark.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.spark.controller.UserController;

public class SparkApplication implements spark.servlet.SparkApplication {
	
	@SuppressWarnings("resource")
	@Override
	public void init() {
		final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
		UserController userController = (UserController) applicationContext.getBean("userController");
		userController.init();
	}
}
