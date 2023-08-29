package com.picpay.picpaydemo.dtos;

import java.math.BigDecimal;

public record TransactionDTO(BigDecimal value, String senderId, String receiverId) {



}
