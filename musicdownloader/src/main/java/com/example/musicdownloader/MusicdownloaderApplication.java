package com.example.musicdownloader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.content.commons.repository.ContentStore;
import org.springframework.content.fs.config.EnableFilesystemStores;
import org.springframework.content.rest.StoreRestResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResourceLoader;

import java.io.File;
import java.util.UUID;

@SpringBootApplication
public class MusicdownloaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicdownloaderApplication.class, args);
	}

	@Configuration
	@EnableFilesystemStores
	public static class StorageConfig {
		File filesystemRoot() {
			return new File("/home/dude/Documents/Music/");
		}

		@Bean
		public FileSystemResourceLoader fsResourceLoader() throws Exception {
			return new FileSystemResourceLoader();
		}
	}

	@StoreRestResource(path="Song")
	public interface SoundsContentStore extends ContentStore<UUID,String> {
		//
	}
}
