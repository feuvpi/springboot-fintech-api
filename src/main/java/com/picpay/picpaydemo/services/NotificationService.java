package com.picpay.picpaydemo.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {
    @Autowired
    private RestTemplate restTemplate;
    public void sendNotification(User user, String message){
        String email = user.getEmail();

        = restTemplate.postForEntity();
    }
}
