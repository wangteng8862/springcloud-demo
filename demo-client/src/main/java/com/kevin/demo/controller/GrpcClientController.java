package com.kevin.demo.controller;

import com.kevin.demo.service.GrpcClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: god_ole
 * @Date: 2021/3/4 15:47
 */
@RestController
public class GrpcClientController {

    @Autowired
    private GrpcClientService grpcClientService;

    @RequestMapping("/hello")
    public String printMessage(@RequestParam(defaultValue = "Michael") String name) {
        return grpcClientService.sendMessage(name);
    }

}
