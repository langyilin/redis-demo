package com.ctg.redis.demo.service;


import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class DemoService {

    @Resource
    private RedisTemplate<String, Integer> redisTemplate;


    public Map<String, Integer> get() {
        Integer value = redisTemplate.opsForValue().get("times");

        if (null == value) {
            value = 1;
        } else {
            value++;
        }
        redisTemplate.opsForValue().set("times", value);


        HashMap<String, Integer> result = new HashMap<>();
        result.put("times", value);
        return result;
    }
}
