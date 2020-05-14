package com.us.messageproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(DocumentBindings.class)
public class MessageProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageProducerApplication.class, args);
	}

}
