package com.example.musicdownloader;


import org.hibernate.cfg.Environment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;



@SpringBootApplication
public class MusicdownloaderApplication {


//	private static final Logger logger = LoggerFactory.getLogger(MusicdownloaderApplication.class);
//	private static boolean stop = false;
//
//
//	@Autowired
//	private static Environment env;
//
//	private static void checkEnvironmentVariable(String envvar)
//	{
//		if (System.getenv(envvar) == null)
//		{
//			logger.error("Environment Variable " + envvar + " missing");
//			stop = true;
//		}
//	}

	public static void main(String[] args) {
//		checkEnvironmentVariable("OAUTHCLIENTID");
//		checkEnvironmentVariable("OAUTHCLIENTSECRET");
//		if (!stop) {
			SpringApplication.run(MusicdownloaderApplication.class, args);

//
//		}
	}

}
