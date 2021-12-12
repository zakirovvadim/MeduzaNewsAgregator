package ru.news.front.app.config.security.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.news.front.app.feign.UserFeignClient;
import ru.news.front.app.model.User;
@Service
@RequiredArgsConstructor
public class UserDeatailsServiceImpl implements UserDetailsService {
    private final UserFeignClient userFeignClient;
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userFeignClient.findByLogin(username);
        return AuthUser.fromUser(user);
    }

}
