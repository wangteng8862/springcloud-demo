package com.kevin.demo.main.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Description:
 * @Author: god_ole
 * @Date: 2021/3/8 16:38
 */
@Configuration
@ImportResource(locations = {"classpath:config/spring/spring-tx.xml"})
@EnableTransactionManagement
public class TxManagerConfiguration {
}
