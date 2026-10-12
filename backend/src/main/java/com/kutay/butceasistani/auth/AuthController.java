package com.kutay.butceasistani.auth;

import com.kutay.butceasistani.user.RegisterRequest;
import com.kutay.butceasistani.user.User;
import com.kutay.butceasistani.user.UserResponse;
import com.kutay.butceasistani.user.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse register(@Valid @RequestBody RegisterRequest request) {
        User user = userService.register(request);
        return new UserResponse(user.getId(), user.getEmail(), user.getCreatedAt());
    }
}