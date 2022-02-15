package com.example.controller;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.model.Cart;
import com.example.model.Order;
import com.example.model.Product;
import com.example.repository.CartRepository;
import com.example.repository.OrderRepository;
import com.example.repository.ProductRepository;
import com.example.repository.UserDetailRepository;
import com.example.repository.UserRepository;
import com.example.serviceImpl.ProductService;
import com.example.serviceImpl.UserService;

@Controller
public class CartController {
	
	
	@Autowired
	CartRepository cartRepo;

	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	UserDetailRepository userdetailRepo;
	@Autowired
	OrderRepository orderRepo;
	
	@GetMapping("/goToCart")
	public String viewCart(Model model) {
		List<Cart> cart=(List<Cart>)cartRepo.findAll();
		model.addAttribute("listCart",cart);
		return "Cart";
	}
	
	@GetMapping("/cart/deleteProduct/{id}")
	public String deleteProductinCartbyid(Model model,@PathVariable Integer id) {
		List<Cart> cartList=cartRepo.findProductbyProductID(id);
		Product product=productRepo.findById(id).orElse(null);
		
		for(Cart cart:cartList) {
			int quan=cart.getQuantity();
		product.setQuantity(product.getQuantity()+quan);
		productRepo.save(product);
		}
		cartRepo.deleteCartProductByProductId(id);
		
		return "redirect:/goToCart";
	}
	
	@GetMapping("/cart/addSameProduct/{id}")
	public String addProductQuantityToCart(@PathVariable Integer id)
	{
		
		Product product=productRepo.findById(id).orElse(null);
		List<Cart> cartList=cartRepo.findProductbyProductID(id);
//		product.setQuantity(product.getQuantity()+1);
//		productRepo.save(product);
		for(Cart cart:cartList) {
			int quan=cart.getQuantity();
		if(product.getQuantity()>quan) {
			product.setQuantity(product.getQuantity()-1);
			productRepo.save(product);
		cartRepo.addToProductQuantity(id);}}
		return"redirect:/goToCart";
	}
	
	///cart/remove1Product/
	@GetMapping("/cart/remove1Product/{id}")
	public String remove1ProductQuantityToCart(@PathVariable Integer id)
	{
		Product product=productRepo.findById(id).orElse(null);
		product.setQuantity(product.getQuantity()+1);
		productRepo.save(product);
		List<Cart> cartList=cartRepo.findProductbyProductID(id);
		for(Cart cart:cartList) {
			int quan=cart.getQuantity();
		if(quan==1) 
		{
			
			cartRepo.deleteCartProductByProductId(id);
			
		}
		else {
		cartRepo.remove1ProductQuantity(id);
		}
		}
		return"redirect:/goToCart";
	}
	
	
	@PostMapping("/customer/OrderPlaced")
	public String orderPlaced()
	{
		
		cartRepo.clearCartProductsAfterCheckout();
		Order order=new Order();
		Date now = new Date();
		order.setOrderDate(now);
		orderRepo.save(order);
		
		
		//delete cart products
		return"EndScreen";
	}
	
//	@GetMapping("/customer/checkout")
//	public String clearCartProducts() 
//	{
//		
//		return"EndScreen";
//	}

}
