package com.example.musicdownloader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@EnableJpaAuditing
@SpringBootApplication
public class MusicdownloaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicdownloaderApplication.class, args);
	}

}
