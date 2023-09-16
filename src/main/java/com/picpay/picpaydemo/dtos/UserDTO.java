package com.picpay.picpaydemo.dtos;

import com.picpay.picpaydemo.domain.user.UserRole;

import java.math.BigDecimal;

public record UserDTO(String firstName, String lastName, String document, BigDecimal balance, String email, String password, UserRole role, BigDecimal amount) {


}
