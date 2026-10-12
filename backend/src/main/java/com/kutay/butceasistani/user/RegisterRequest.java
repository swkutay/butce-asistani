package com.kutay.butceasistani.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterRequest(

        @NotBlank(message = "Email boş olamaz")
        @Email(message = "Geçerli bir email giriniz")
        String email,

        @NotBlank(message = "Şifre boş olamaz")
        @Size(min = 8, max = 72, message = "Şifre 8-72 karakter olmalı")
        String password
) {
}