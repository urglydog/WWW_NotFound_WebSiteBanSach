package com.notfound.bookstore.controller;

import com.notfound.bookstore.model.dto.request.userrequest.LoginRequest;
import com.notfound.bookstore.model.dto.response.ApiResponse;
import com.notfound.bookstore.model.dto.response.userresponse.AuthResponse;
import com.notfound.bookstore.service.AuthService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthController {
    AuthService authService;

    @PostMapping("/login")
    public ApiResponse<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
        AuthResponse authResponse = authService.login(request);
        return ApiResponse.<AuthResponse>builder()
                .code(1000)
                .message("Đăng nhập thành công")
                .result(authResponse)
                .build();
    }
}