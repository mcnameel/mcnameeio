package io.mcnamee;

import io.mcnamee.service.PostService;
import io.mcnamee.service.PostServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class McnameewebApplication {

    @Bean(name="postService")
    public PostService postService(){
        return new PostServiceImpl();
    }


	public static void main(String[] args) {
		SpringApplication.run(McnameewebApplication.class, args);
	}
}
