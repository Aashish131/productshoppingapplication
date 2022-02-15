package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Cart;

public interface CartRepository extends CrudRepository<Cart, Integer>
{
	@Transactional
	@Modifying
	@Query("DELETE from Cart p where p.product_id=:Product_Code")
	public void deleteCartProductByProductId(@Param("Product_Code")Integer Product_Code);
	//clearCartProductsAfterCheckout

	

	@Transactional
	@Modifying
	@Query("DELETE from Cart")
	public void clearCartProductsAfterCheckout();
	
	
//	//addToProductQuantity
	@Transactional
	@Modifying
	@Query("UPDATE Cart p SET  p.quantity=p.quantity + 1 WHERE p.product_id=:id")
	public void addToProductQuantity(@Param("id")Integer id);
	
	
	@Transactional
	@Modifying
	@Query("UPDATE Cart p SET  p.quantity=p.quantity-1 WHERE p.product_id=:id")
	public void remove1ProductQuantity(@Param("id")Integer id);
	
	
	//findProductbyProductID
	@Transactional
	@Modifying
	@Query("SELECT p from Cart p  where p.product_id=:id")
	public List<Cart> findProductbyProductID(@Param("id")Integer id);
	
	
//	@Transactional
//	@Modifying
//	@Query("SELECT p from Cart p  where p.product_id=:id")
//	public Cart findCartProductQuantitybyProductID(@Param("id")Integer id);
//	
	
	@Transactional
	@Modifying
	@Query("SELECT p.quantity from Cart p  where p.product_id=:id")
	public int getSpecificProductQuantityFromCart(@Param("id")Integer id);
	
}
