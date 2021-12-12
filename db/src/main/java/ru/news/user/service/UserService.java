package ru.news.user.service;


import ru.news.user.model.User;

public interface UserService extends MyNewsService<User, Long> {
    User findByLogin(String login);
}

