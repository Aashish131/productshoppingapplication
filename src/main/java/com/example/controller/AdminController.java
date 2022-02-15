package com.example.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.model.Product;
import com.example.model.User;
import com.example.repository.ProductRepository;
import com.example.repository.UserRepository;
import com.example.serviceImpl.ProductService;
import com.example.serviceImpl.UserService;



@Controller
public class AdminController {
	@Autowired
	private UserService service;
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private ProductService productService;
	
	
	
	@GetMapping("/users/export/excel")
    public void exportUserListToExcel(HttpServletResponse response) throws IOException {
        List<User> listUsers=service.listAll();
       
        UserExcelExporter exporter=new UserExcelExporter();
        exporter.export(listUsers, response);
    }

	@GetMapping("/product/export/excel")
    public void exportProductListToExcel(HttpServletResponse response) throws IOException {
        List<Product> listProduct = productService.listAll();
       
        ProductExcelExporter exporter=new ProductExcelExporter();
        exporter.export(listProduct, response);
    }

	@GetMapping("/AdminHome")
	public String view() {
		return "AdminHome";
	}

	@GetMapping("/userList")
	public String listAll(Model model) {
		List<User> listUsers = service.listAll();
		System.out.print(listUsers);
		model.addAttribute("listUsers", listUsers);

		return "listofUsers";
	}

	@GetMapping("/productsList")
	public String productList(Model model) {
		List<Product> listProduct = productService.listAll();
		System.out.print(listProduct);
		model.addAttribute("listProduct", listProduct);
		return "listofProducts";
	}

	@GetMapping("/AddUser")
	public String newUser(Model model) {

		User user = new User();
		model.addAttribute("user", user);
		return "AddUser";
	}
	
	@PostMapping("/userAdded")
	public String userAdded(User user)
	{
		service.save(user);
		return "redirect:/userList";
	}

	@GetMapping("/AddProduct")
	public String addProduct(Model model) {
		Product product=new Product();
		model.addAttribute("product",product);
		return "AddProduct";
	}
	
	@PostMapping("/productAdded")
	public String productAdded(Product product) 
	{
		productService.save(product);
		return "redirect:/productsList";
	}
	
	
	
	@GetMapping("/edit/{id}")
	public String editUserByid(@PathVariable ("id") Integer id,Model model) {
		User user=userRepo.findById(id).orElse(null);
		model.addAttribute("user", user);
		return "editUserForm";
	}
	@GetMapping("/delete/{id}")
	public String deleteUserByid(@PathVariable ("id") Integer id,Model model) {
		userRepo.deleteById(id);
		return "redirect:/userList";
	}
	@GetMapping("/editProduct/{id}")
	public String editProductByid(@PathVariable ("id") Integer id,Model model) {
		Product product=productRepo.findById(id).orElse(null);
		model.addAttribute("product", product);
		return "editProductForm";
	}
	@GetMapping("/deleteProduct/{id}")
	public String deleteProductByid(@PathVariable ("id") Integer id,Model model) {
		productRepo.deleteById(id);
		return "redirect:/productsList";
	}
	
	@GetMapping("/usersSearch")
	public String viewHomePage(@Param("keyword")  String keyword,Model model) {
		
		
		if(keyword!=null) 
		{
			List<User>userlist=userRepo.findbyFirstName(keyword);
			model.addAttribute("listUsers", userlist);
			model.addAttribute("keyword", keyword);
			return "reportResults";
		}
		else 
		{
			model.addAttribute("listUsers",userRepo.findAll());
			return "redirect:/userList";
		}	
		
		//model.addAttribute("user", user1);
		
	
	}
	
	
	@GetMapping("/productSearch")
	public String viewProductPage(@Param("keyword")  String keyword,Model model) {
		
		
		if(keyword!=null) 
		{
			List<Product>productlist=productRepo.findbyFirstName(keyword);
			model.addAttribute("listProduct",productlist);
			model.addAttribute("keyword", keyword);
			return "productReport";
		}
		else 
		{
			model.addAttribute("listProduct",productRepo.findAll());
			return "redirect:/productsList";
		}	
		
		//model.addAttribute("user", user1);
		
	
	}
//	@GetMapping("/usersSearch/Filtereduser")
//	public String viewFilterUser(User user,Model model) {
//		List<User>userlist=userRepo.findbyFirstName(user.getFirstName());
//		model.addAttribute("userlist", userlist);
//		
//		//model.addAttribute("user", user1);
//		return "reportResults";
//	
//	}
//	
//	
	
	

}
