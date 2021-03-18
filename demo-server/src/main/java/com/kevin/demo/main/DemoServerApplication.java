package com.kevin.demo.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @Description:
 * @Author: god_ole
 * @Date: 2021/3/3 17:55
 */

@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class
})
@ComponentScan("com.kevin.demo")
@EnableDiscoveryClient
public class DemoServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoServerApplication.class, args);
    }
}
