package com.kevin.demo.controller;

import com.kevin.demo.entity.TOrder;
import com.kevin.demo.service.TOrderManageService;
import com.kevin.demo.service.TOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @Author: god_ole
 * @Date: 2021/3/4 17:31
 */
@RestController
public class ConsulHealthController {

    @Autowired
    private TOrderManageService orderManageService;

    @RequestMapping("/health")
    public String health() {
        return "consul";
    }

    @RequestMapping("/getAll")
    public List<TOrder> getAll() {
        return orderManageService.findAll();
    }

    @RequestMapping("/add")
    public void add() {
        try {
            orderManageService.add();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
