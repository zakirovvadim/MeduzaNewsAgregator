package ru.news.front.app.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AuthController {

    @Value("${security.anonym}")
    private String anonymousUser;

    @GetMapping("/auth/login")
    public String loginPage() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getPrincipal().equals(anonymousUser)) {
            return "login";
        } else
            return "redirect:/mynews";

    }
    @GetMapping("/auth/logout")
    public String getLogoutPage() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!auth.getPrincipal().equals(anonymousUser)) {
            return "logout";
        } else
            return "redirect:/auth/login";
    }
}
