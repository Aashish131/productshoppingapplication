package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Product;
import com.example.model.User;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
//	
	@Transactional
	@Modifying
	@Query("SELECT p from Product p  where p.code=:id")
	public List<Product> findProductFromProductTId(@Param("id")Integer id);

	@Transactional
	@Modifying
    @Query("SELECT p FROM Product p WHERE p.name LIKE %?1%" )
    public List<Product> findbyFirstName(@Param("keyword") String keyword);

}
