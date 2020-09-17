package com.ctg.redis.demo.api;

import com.ctg.redis.demo.service.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
public class DemoApi {

    @Resource
    private DemoService demoService;

    @GetMapping("")
    public Map<String, Integer> demo() {
        return demoService.get();
    }

}
