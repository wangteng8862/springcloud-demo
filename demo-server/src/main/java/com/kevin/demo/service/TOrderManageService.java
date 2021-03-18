package com.kevin.demo.service;

import com.kevin.demo.entity.TOrder;

import java.util.List;

public interface TOrderManageService {

    List<TOrder> findAll();

    void add() throws Exception;
}
