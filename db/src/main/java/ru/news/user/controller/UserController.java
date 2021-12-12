package ru.news.user.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.news.user.model.User;
import ru.news.user.service.MyNewsService;
import ru.news.user.service.UserService;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserService myNewsService;

    @GetMapping("/")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(myNewsService.findAll());
    }
    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.ok(myNewsService.save(user));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable String id) {
        return ResponseEntity.ok(myNewsService.update(user, Long.parseLong(id)));
    }
    @PutMapping("/delete/{id}")
    public ResponseEntity<User> delete(@PathVariable String id) {
        return ResponseEntity.ok(myNewsService.delete(Long.parseLong(id)));
    }

    @GetMapping("/find-by-login/{login}")
    public ResponseEntity<User> findByLogin(@PathVariable String login) {
        return ResponseEntity.ok(myNewsService.findByLogin(login));
    }
}
