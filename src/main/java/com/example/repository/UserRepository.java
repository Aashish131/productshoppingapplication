package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.User;
@Transactional
@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

	//public Long countById(Integer id);
	
	@Modifying
    @Query("SELECT u FROM User u WHERE u.firstName LIKE %?1%" )
    public List<User> findbyFirstName(@Param("keyword") String keyword);
	}
