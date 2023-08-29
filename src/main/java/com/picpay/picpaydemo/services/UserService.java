package com.picpay.picpaydemo.services;

import com.picpay.picpaydemo.domain.user.User;
import com.picpay.picpaydemo.domain.user.UserType;
import com.picpay.picpaydemo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    public void validateTransaction(User sender, BigDecimal amount) throws Exception {
        if(sender.getUserType() == UserType.MERCHANT){
            throw new Exception("User type not authorized.");
        }

        if(sender.getBalance().compareTo(amount) < 0){
            throw new Exception("Insufficient funds.");
        }
    }

    public User findUserById(String id) throws Exception {
        return this.repository.findUserById(id).orElseThrow(() -> new Exception("User not found."));
    }

    public void saveUser(User user){
        this.repository.save(user);
    }
}
