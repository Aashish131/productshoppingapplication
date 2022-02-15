package com.example.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Cart;
import com.example.repository.CartRepository;
@Service
public class CartService {
	@Autowired
	CartRepository cartRepo;
	
	public List<Cart> listAll()
	{
		return (List<Cart>)cartRepo.findAll();
	}

	 public void save(Cart cart) {
	        // TODO Auto-generated method stub
	        cartRepo.save(cart);
	        
	    }
}
