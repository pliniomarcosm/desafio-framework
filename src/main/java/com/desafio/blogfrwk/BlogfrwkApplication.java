package com.desafio.blogfrwk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.desafio.blogfrwk.properties.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class BlogfrwkApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogfrwkApplication.class, args);
	}

}
