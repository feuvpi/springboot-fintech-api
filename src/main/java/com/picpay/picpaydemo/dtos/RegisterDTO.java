package com.picpay.picpaydemo.dtos;

import com.picpay.picpaydemo.domain.user.UserRole;

public record RegisterDTO(String email, String password, String firstName, String lastName, String document) {
}
