package com.hr.hroauth.feignClients;

import com.hr.hroauth.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Component
@FeignClient(name = "hr-user", path="/users")
public interface UserFeignClient {

    @GetMapping(value = "/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email);
}
