package com.kevin.demo.repository;

import com.kevin.demo.entity.TOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TOrderRepository extends JpaRepository<TOrder, Long>{}
