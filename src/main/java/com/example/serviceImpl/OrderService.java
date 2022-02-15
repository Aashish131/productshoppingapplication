package com.example.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Order;
import com.example.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	OrderRepository orderRepo;
	
	public List<Order> listAll()
	{
		return (List<Order>)orderRepo.findAll();
	}

	 public void save(Order order) {
	        // TODO Auto-generated method stub
	        orderRepo.save(order);
	        
	    }

}
