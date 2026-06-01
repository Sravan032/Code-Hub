package com.sravan.Coding_Platform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class RateLimitService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private static final int MAX_REQUESTS = 5;
    public boolean isAllowed(String ipAddress){
        String key = "login_attempts:"+ipAddress;
        String currentCount = stringRedisTemplate.opsForValue().get(key);

        int count;
        if(currentCount==null){
            count=0;
        }else{
            count = Integer.parseInt(currentCount);
        }
        if(count>MAX_REQUESTS) return false;
        stringRedisTemplate.opsForValue().increment(key);
        stringRedisTemplate.expire(key, Duration.ofMinutes(1));
        return true;
    }
}
