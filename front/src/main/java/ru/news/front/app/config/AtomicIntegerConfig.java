package ru.news.front.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.atomic.AtomicInteger;

@Configuration
public class AtomicIntegerConfig {

    @Bean(value = "prototype")
    public AtomicInteger atomicInteger() {
        return new AtomicInteger(0);
    }
}
