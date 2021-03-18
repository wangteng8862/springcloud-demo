package com.kevin.demo.service.impl;

import com.kevin.demo.entity.TOrder;
import com.kevin.demo.service.TOrderManageService;
import com.kevin.demo.service.TOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TOrderManageServiceImpl implements TOrderManageService {

    @Autowired
    private TOrderService orderService;

    @Override
    public List<TOrder> findAll() {
        return orderService.findAll();
    }

    @Override
    public void add() throws Exception {
        orderService.addNewTransaction();

        if (true) {
            throw new Exception();
        }
    }
}
