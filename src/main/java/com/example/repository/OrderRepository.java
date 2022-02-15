package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {

}
