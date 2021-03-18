package com.kevin.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: god_ole
 * @Date: 2021/3/4 17:31
 */
@RestController
public class ConsulHealthController {

    @RequestMapping("/health")
    public String health() {
        return "consul";
    }
}
