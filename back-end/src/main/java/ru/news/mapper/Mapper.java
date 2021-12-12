package ru.news.mapper;

public interface Mapper<Model,DTO> {
    DTO toDTO(Model model);
   // Model toModel(DTO dto);
}
