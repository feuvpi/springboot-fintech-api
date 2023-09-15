package com.picpay.picpaydemo.services;
import com.picpay.picpaydemo.domain.user.User;
updaimport com.picpay.picpaydemo.domain.user.UserRole;
import com.picpay.picpaydemo.dtos.UserDTO;
import com.picpay.picpaydemo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    public void validateTransaction(User sender, BigDecimal amount) throws Exception {
        if(sender.getRole() == UserRole.MERCHANT){
            throw new Exception("User type not authorized.");
        }

        if(sender.getBalance().compareTo(amount) < 0){
            throw new Exception("Insufficient funds.");
        }
    }

    public User findUserById(String id) throws Exception {
        return this.repository.findUserById(id).orElseThrow(() -> new Exception("User not found."));
    }

    public List<User> getAllUsers(){
        return this.repository.findAll();
    }

    public User createUser(UserDTO user){
        User newUser = new User(user);
        this.saveUser(newUser);
        return newUser;
    }

    public User createUser(UserDTO user, BigDecimal amount){
        User newUser = new User(user);
        newUser.setBalance(amount);
        this.saveUser(newUser);
        return newUser;
    }

    public void saveUser(User user){
            this.repository.save(user);
    }
}
