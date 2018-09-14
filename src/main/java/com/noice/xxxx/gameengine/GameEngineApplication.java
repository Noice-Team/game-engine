package com.noice.xxxx.gameengine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.noice.xxxx.gameengine")
public class GameEngineApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameEngineApplication.class, args);
	}
}
