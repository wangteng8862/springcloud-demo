package com.kevin.demo.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description:
 * @Author: god_ole
 * @Date: 2021/3/3 17:55
 */

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("com.kevin.demo")
public class DemoClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoClientApplication.class, args);
    }
}
