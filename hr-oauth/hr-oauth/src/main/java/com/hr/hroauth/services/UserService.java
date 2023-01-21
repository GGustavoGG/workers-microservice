package com.hr.hroauth.services;

import com.hr.hroauth.entities.User;
import com.hr.hroauth.feignClients.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {

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
}
