package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.model.Cart;
import com.example.model.Product;
import com.example.model.User;
import com.example.repository.CartRepository;
import com.example.repository.ProductRepository;
import com.example.repository.UserRepository;
import com.example.serviceImpl.ProductService;
import com.example.serviceImpl.UserService;

@Controller
public class CustomerController {
	@Autowired
	private UserService service;
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CartRepository cartRepo;

	
	@GetMapping("/CustomerHome")
	public String viewHome() {
		return "CustomerHome";
	}
	
	@GetMapping("/customer/MyAccount")
	public String viewMyAccount() {
		return "CustomerAccountPage";
	}
	@GetMapping("/customer/productsListforCustomer")
	public String viewProductListforCustomer(Model model) {
		List<Product> listProducts=productService.listAll();
		model.addAttribute("listProducts", listProducts);
		return "CustomerViewProduct";
	}
	@GetMapping("/addToCart/{id}")
	public String addedToCart(Model model,@PathVariable ("id") Integer id) {
		Product product=productRepo.findById(id).orElse(null);
		
		productService.cartProduct(product);
		
//		List<Cart> cartProducts=(List<Cart>)productRepo.findById(id);
//		model.addAttribute("listProducts", listProducts);
		return "redirect:/customer/productsListforCustomer";
	}

	@GetMapping("/addOrderDetails")
	public String AddOrderDetails()
	{
		//object
		List<Cart>cartList=(List<Cart>)cartRepo.findAll();
		if(cartList.isEmpty()) 
		{
			return"redirect:/goToCart";
		}
		return "OrderDetails";
	}	
	
	
	
	
	
//	@GetMapping("/userList")
//	public String listAll(Model model) {
//		List<User> listUsers = service.listAll();
//		System.out.print(listUsers);
//		model.addAttribute("listUsers", listUsers);
//
//		return "listofUsers";
//	}
//
//	@GetMapping("/productsList")
//	public String productList(Model model) {
//		List<Product> listProduct = productService.listAll();
//		System.out.print(listProduct);
//		model.addAttribute("listProduct", listProduct);
//		return "listofProducts";
//	}
//
//	@GetMapping("/AddUser")
//	public String newUser(Model model) {
//
//		User user = new User();
//		model.addAttribute("user", user);
//		return "AddUser";
//	}
//	
//	@PostMapping("/userAdded")
//	public String userAdded(User user)
//	{
//		service.save(user);
//		return "redirect:/userList";
//	}
//
//	@GetMapping("/AddProduct")
//	public String addProduct(Model model) {
//		Product product=new Product();
//		model.addAttribute("product",product);
//		return "AddProduct";
//	}
//	
//	@PostMapping("/productAdded")
//	public String productAdded(Product product) 
//	{
//		productService.save(product);
//		return "redirect:/productsList";
//	}
//	
//	
//	
//	@GetMapping("/edit/{id}")
//	public String editUserByid(@PathVariable ("id") Integer id,Model model) {
//		User user=userRepo.findById(id).orElse(null);
//		model.addAttribute("user", user);
//		return "editUserForm";
//	}
//	@GetMapping("/delete/{id}")
//	public String deleteUserByid(@PathVariable ("id") Integer id,Model model) {
//		userRepo.deleteById(id);
//		return "redirect:/userList";
//	}
//	@GetMapping("/editProduct/{id}")
//	public String editProductByid(@PathVariable ("id") Integer id,Model model) {
//		Product product=productRepo.findById(id).orElse(null);
//		model.addAttribute("product", product);
//		return "editProductForm";
//	}
//	@GetMapping("/deleteProduct/{id}")
//	public String deleteProductByid(@PathVariable ("id") Integer id,Model model) {
//		productRepo.deleteById(id);
//		return "redirect:/productsList";
//	}

}
