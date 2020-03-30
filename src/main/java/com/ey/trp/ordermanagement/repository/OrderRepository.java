package com.ey.trp.ordermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ey.trp.ordermanagement.model.OrderMgmt;
@Repository
public interface OrderRepository extends JpaRepository<OrderMgmt,Integer>{

}
