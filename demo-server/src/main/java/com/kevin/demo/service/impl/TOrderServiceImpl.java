package com.kevin.demo.service.impl;

import com.kevin.demo.entity.TOrder;
import com.kevin.demo.repository.TOrderRepository;
import com.kevin.demo.service.TOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TOrderServiceImpl implements TOrderService {

    @Autowired
    private TOrderRepository tOrderRepository;

    @Override
    public List<TOrder> findAll() {
        return tOrderRepository.findAll();
    }

    @Override
    public void addNewTransaction() throws Exception {
        TOrder order = new TOrder();
        order.setAmount(1);
        order.setUserId(1);
        tOrderRepository.save(order);
    }
}
