package com.picpay.picpaydemo.services;

import com.picpay.picpaydemo.domain.transaction.Transaction;
import com.picpay.picpaydemo.domain.user.User;
import com.picpay.picpaydemo.dtos.TransactionDTO;
import com.picpay.picpaydemo.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class TransactionService {

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionRepository repository;

    @Autowired
    private RestTemplate restTemplate; // built in spring class to allow http connections

    @Autowired
    private NotificationService notificationService;

    public Transaction createTransaction(TransactionDTO transactionDTO) throws Exception {
            User sender = this.userService.findUserById(transactionDTO.senderId());
            User receiver = this.userService.findUserById(transactionDTO.receiverId());
            userService.validateTransaction(sender, transactionDTO.value());

            if(!authorizeTransaction(sender, transactionDTO.value())){
                throw new Exception("Not authorized.");
            }

            Transaction transaction = new Transaction();
            transaction.setAmount(transactionDTO.value());
            transaction.setSender(sender);
            transaction.setReceiver(receiver);
            transaction.setTimestamp(LocalDateTime.now());

            sender.setBalance(sender.getBalance().subtract(transaction.getAmount()));
            receiver.setBalance(receiver.getBalance().add(transaction.getAmount()));

            this.repository.save(transaction);
            this.userService.saveUser(sender);
            this.userService.saveUser(receiver);
            this.notificationService.sendNotification(sender, "Transaction sent!");
            this.notificationService.sendNotification(receiver, "Transaction received!");

            return transaction;
    }

    public boolean authorizeTransaction(User sender, BigDecimal amount){
            ResponseEntity<Map> authorizationResponse = restTemplate.getForEntity("https://run.mocky.io/v3/8fafdd68-a090-496f-8c9a-3442cf30dae6", Map.class);

            if(authorizationResponse.getStatusCode() == HttpStatus.OK){
                String message = (String) authorizationResponse.getBody().get("message");
                return "Authorized".equalsIgnoreCase(message);
            } else return false;
    }

    public List<Transaction> getAllTransactions(){
        return this.repository.findAll();
    }
}
