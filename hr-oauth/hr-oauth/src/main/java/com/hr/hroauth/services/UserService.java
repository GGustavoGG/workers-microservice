package com.hr.hroauth.services;

import com.hr.hroauth.entities.User;
import com.hr.hroauth.feignClients.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserFeignClient userFeignClient;

    public User findByEmail(String email) {
        User user = userFeignClient.findByEmail(email).getBody();
        if (Objects.isNull(user)) {
            logger.error("Email not found: {}", email);
            throw new IllegalArgumentException("Emanil not found");
        }
        logger.error("Email found: {}", email);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userFeignClient.findByEmail(email).getBody();
        if (Objects.isNull(user)) {
            logger.error("Email not found: {}", email);
            throw new UsernameNotFoundException("Email not found");
        }
        logger.info("Email found: {}", email);
        return user;
    }
}
