package com.picpay.picpaydemo.dtos;

import com.picpay.picpaydemo.domain.user.UserType;

import java.math.BigDecimal;

public record UserDTO(String firstName, String lastName, String document, BigDecimal balance, String email, String password, BigDecimal amount) {


}
