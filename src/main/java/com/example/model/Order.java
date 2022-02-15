package com.example.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Orders")
public class Order {
     
     @Id
     @GeneratedValue
     @Column(name = "Order_ID", length = 50)
     private Integer id;
     
  
     @Column(name = "Order_Date", nullable = false)
     private Date orderDate;
  

 	@Column(name = "Amount", nullable = true)
      private double amount;
 	
	

  
     public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Date getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}




	@Override
	public String toString() {
		return "Order [id=" + id + ", orderDate=" + orderDate + ", amount=" + amount + "]";
	}


	public Order(Integer id, Date orderDate, double amount) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		this.amount = amount;
	}




	public Order() {
		
	}


  
}
