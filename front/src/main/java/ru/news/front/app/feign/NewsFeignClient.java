package ru.news.front.app.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.news.front.app.model.News;

@FeignClient(name = "MSNews", value = "MSNews")
public interface NewsFeignClient {
    @GetMapping("/news")
    News getNews(@RequestParam String pageNumber);
}
