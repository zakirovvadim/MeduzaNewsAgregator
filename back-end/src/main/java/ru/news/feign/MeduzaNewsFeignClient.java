package ru.news.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.news.model.dto.NewsDTO;

@FeignClient(name = "meduza", url = "https://meduza.io/api/v3/search?chrono=news&locale=ru&page=0&per_page=24")
public interface MeduzaNewsFeignClient {
    @RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET, value = "/")
    NewsDTO getNews();
}
