package com.sravan.Coding_Platform.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Async("TaskExecutor")
    public void sendSubmissionNotification(String email){
        try {
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Notification sent successfully to "+ email);
    }
}
