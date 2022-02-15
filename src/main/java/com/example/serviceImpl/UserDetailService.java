package com.example.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.User_Details;
import com.example.repository.UserDetailRepository;

@Service
public class UserDetailService {

	@Autowired
	UserDetailRepository userDetailRepo;
	
	public List<User_Details> listAll()
	{
		return (List<User_Details>)userDetailRepo.findAll();
	}

	 public void save(User_Details cart) {
	        // TODO Auto-generated method stub
		 userDetailRepo.save(cart);
	        
	    }
}
