package ru.news.front.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.news.front.app.feign.UserFeignClient;
import ru.news.front.app.model.User;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminController {
    private final UserFeignClient userFeignClient;
    @GetMapping("/admin")
    public String adminPage(ModelMap modelMap) {
        List<User> listUsers = userFeignClient.getUserList();
        modelMap.addAttribute("users", listUsers);
        return "adminPage";
    }
}
