package ru.news.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import ru.news.feign.MeduzaNewsFeignClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(clients = {MeduzaNewsFeignClient.class})
@ComponentScan("ru.news")
public class NewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsApplication.class, args);
	}

}
