package com.example.serviceImpl;

import java.util.List;

import javax.naming.InitialContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Cart;
import com.example.model.Product;
import com.example.repository.CartRepository;
import com.example.repository.ProductRepository;

@Service
public class ProductService 
{
	@Autowired
	ProductRepository productRepo;
	@Autowired
	CartRepository cartRepo;
	
	public List<Product> listAll()
	{
		return (List<Product>)productRepo.findAll();
	}

	 public void save(Product pro) {
	        // TODO Auto-generated method stub
	        productRepo.save(pro);
	        
	    }
	 public void cartProduct(Product product) 
	 {
		 if(cartRepo.findProductbyProductID(product.getCode()).isEmpty())
		 {Cart cart=new Cart();
		 cart.setName(product.getName());
		 cart.setPrice(product.getPrice());
		 cart.setProduct_id(product.getCode());
		 cart.setQuantity(1);
		 cartRepo.save(cart);
		Product productDb= productRepo.findById(product.getCode()).orElse(null);
		productDb.setQuantity((product.getQuantity())-1);
		Product product2=product;
		product2.setQuantity(productDb.getQuantity());
		productRepo.save(product2);
		 }
		 else 
		 {
			 cartRepo.addToProductQuantity(product.getCode());
			 Product productDb= productRepo.findById(product.getCode()).orElse(null);
				productDb.setQuantity((product.getQuantity())-1);
				Product product2=product;
				product2.setQuantity(productDb.getQuantity());
				productRepo.save(product2);
		 }
		 
	 }
		    
}
