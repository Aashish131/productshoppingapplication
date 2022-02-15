package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.Order;
import com.example.model.Product;
import com.example.model.User;
import com.example.repository.OrderRepository;
import com.example.repository.ProductRepository;
import com.example.repository.UserRepository;
import com.example.serviceImpl.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@Autowired
	private OrderRepository orderRepo;

	
	
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ProductRepository productRepo;

	@GetMapping({ "/", "/login" })
	public String view() {
		return "login";
	}
//	@GetMapping("")
//	public String home() {
//		return "home";
//
//	}

	@PostMapping("/validation")
	public String validateUser(@RequestParam(value = "email") String email,
			@RequestParam(value = "password") String password, Model model) {
		User user = userService.validateUser(email, password);
		if (user != null) {
			if (user.getRoles().equalsIgnoreCase("Admin")) {

				List<User>userList=(List<User>)userRepo.findAll();
				List<Product>productList=(List<Product>)productRepo.findAll();
				List<Order>orderList=(List<Order>)orderRepo.findAll();
				int userListSize=userList.size();
				int productListSize=productList.size();
				int orderListSize=orderList.size();
				model.addAttribute("userListSize",userListSize);
				model.addAttribute("productListSize", productListSize);
				model.addAttribute("orderListSize", orderListSize);

				return "AdminHome";
			} else {
				model.addAttribute("user", user);
				return "CustomerHome";
			}

		}
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		return "Login";
	}
}
