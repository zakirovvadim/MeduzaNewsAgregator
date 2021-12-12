package ru.news.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewsFields {
    private String url;
    private String title;
    private String shareImageUrl;
    private LocalDate pubDate;
}
