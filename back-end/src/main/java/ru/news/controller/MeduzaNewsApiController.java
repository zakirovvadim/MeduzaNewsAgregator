package ru.news.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import ru.news.feign.MeduzaNewsFeignClient;
import ru.news.mapper.Mapper;
import ru.news.model.News;
import ru.news.model.dto.NewsDTO;

@RestController
@RequiredArgsConstructor
public class MeduzaNewsApiController {

 @Value("${meduza.news.partUrl}")
    private String meduzaNewsPartUrl;

    @Value("${meduza.news.pageUrl}")
    private String meduzaNewsPageUrl;

    @Value("${meduza.news.perPage}")
    private String meduzaNewsPerPageUrl;

    private final MeduzaNewsFeignClient meduzaNewsFeignClient;
    private final Mapper<NewsDTO, News> mapper;

    @GetMapping(value = "/news", produces = "application/json;charset=UTF-8")
    public News getNews(@RequestParam String pageNumber) {
        String meduzaFullUrl =  meduzaNewsPartUrl+meduzaNewsPageUrl+pageNumber+meduzaNewsPerPageUrl;
        WebClient webClient = WebClient.create();
          NewsDTO newsJson = webClient.get()
                .uri(meduzaFullUrl)
                .exchange()
                .block()
                .bodyToMono(NewsDTO.class)
                .block();
        return mapper.toDTO(newsJson) ;
    }



}