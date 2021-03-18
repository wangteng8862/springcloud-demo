package com.kevin.demo.service;

import com.kevin.demo.entity.TOrder;

import java.util.List;

public interface TOrderService {

    List<TOrder> findAll();

    void addNewTransaction() throws Exception;
}
