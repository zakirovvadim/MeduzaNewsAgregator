package ru.news.user.service;

import java.util.List;

public interface MyNewsService<T,ID> {
    List<T> findAll();
    T save(T t);
    T update(T t, ID id);
    T delete(ID id);
}
