package ru.news.user.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import ru.news.user.UserApplication;
import ru.news.user.model.User;
import ru.news.user.repository.UserRepository;
import ru.news.user.service.impl.UserServiceImpl;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when; //нужен для подмены реализации

@SpringBootTest
// второй вариант без спрингбуттеста
//@DataJpaTest
//@ContextConfiguration(classes = {UserApplication.class})
public class UserServiceTest {
    //Второй вариант
//    @MockBean
//    UserRepository userRepository;
//    @Mock
//    UserServiceImpl userService = new UserServiceImpl(userRepository);

    //Первый вариант
    @MockBean
    UserService userService;

    @Test
    void findAll_thenReturnOk() {
        User user = new User();
        user.setLogin("login");
        List<User> list = Arrays.asList(user);
        List<User> list2;
        when(userService.findAll()).thenReturn(list);
        list2 = userService.findAll();
        assertEquals(list, list2);
    }

    @Test
    void save_thenReturnOk() {
        User user = new User();
        user.setLogin("login");
        when(userService.save(user)).thenReturn(user);
        assertEquals(user, userService.save(user));
    }

    @Test
    void update_thenReturnOk() {
        User user = new User();
        user.setLogin("login");
        when(userService.update(user, 1L)).thenReturn(user);
        assertEquals(user, userService.update(user, 1L));
    }

    @Test
    void delete_thenReturnOk() {
        User user = new User();
        user.setLogin("login");
        when(userService.delete(1L)).thenReturn(user);
        assertEquals(user, userService.delete(1L));
    }
}
