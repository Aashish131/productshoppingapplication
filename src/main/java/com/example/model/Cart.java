package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cart")
public class Cart {
	 @Id
     @GeneratedValue
     @Column(name = "Cart_id", length = 50)
     private Integer cart_id;
	
	 @Column(name = "Product_Code", length = 50,unique = true)
     private Integer product_id;
	 
	 
	 
	   @Column(name = "Product_Name", length = 255, nullable = false)
       private String name;
    
       @Column(name = "Product_Price", nullable = false)
       private double price;
    
      
    
       @Column(name = "Product_Quantity", nullable = false)
       private int quantity;



	public Integer getCart_id() {
		return cart_id;
	}



	public void setCart_id(Integer cart_id) {
		this.cart_id = cart_id;
	}



	public Integer getProduct_id() {
		return product_id;
	}



	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public Cart(Integer cart_id, Integer product_id, String name, double price, int quantity) {
		super();
		this.cart_id = cart_id;
		this.product_id = product_id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}



	public Cart() {
	}



	@Override
	public String toString() {
		return "Cart [cart_id=" + cart_id + ", product_id=" + product_id + ", name=" + name + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}
       
     
    
	 
//	 @OneToOne
//	@JoinColumn(name="Product_Code",insertable=false,updatable=false)
//	private Product product;
//		
//	 
//	 @Column(name = "USER_ID", length = 50)
//     private Integer user_id;
//	 
//
//		@ManyToOne(cascade=CascadeType.ALL)
//		@JoinColumn(name="id")
//		private Order orderObj;
//	 
//	 
//	 public Order getOrderObj() {
//			return orderObj;
//		}
//
//		public void setOrderObj(Order orderObj) {
//			this.orderObj = orderObj;
//		}
//
//	@OneToOne
//		@JoinColumn(name="USER_ID",insertable=false,updatable=false)
//		private User user;
//	 
//	 @Column(name = "Order_ID", length = 50)
//     private Integer order_id;
//	 
//	 @OneToOne
//		@JoinColumn(name="Order_ID",insertable=false,updatable=false)
//		private Order order;
//	 
//	 public Cart() {
//		// TODO Auto-generated constructor stub
//	}
//
//	public Integer getCart_id() {
//		return cart_id;
//	}
//
//	public void setCart_id(Integer cart_id) {
//		this.cart_id = cart_id;
//	}
//
//	public Integer getProduct_id() {
//		return product_id;
//	}
//
//	public void setProduct_id(Integer product_id) {
//		this.product_id = product_id;
//	}
//
//	public Product getProduct() {
//		return product;
//	}
//
//	public void setProduct(Product product) {
//		this.product = product;
//	}
//
//	public Integer getUser_id() {
//		return user_id;
//	}
//
//	public void setUser_id(Integer user_id) {
//		this.user_id = user_id;
//	}
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	public Integer getOrder_id() {
//		return order_id;
//	}
//
//	public void setOrder_id(Integer order_id) {
//		this.order_id = order_id;
//	}
//
//	public Order getOrder() {
//		return order;
//	}
//
//	public void setOrder(Order order) {
//		this.order = order;
//	}
//
//	@Override
//	public String toString() {
//		return "Cart [cart_id=" + cart_id + ", product_id=" + product_id + ", product=" + product + ", user_id="
//				+ user_id + ", orderObj=" + orderObj + ", user=" + user + ", order_id=" + order_id + ", order=" + order
//				+ "]";
//	}
//
//	public Cart(Integer cart_id, Integer product_id, Product product, Integer user_id, Order orderObj, User user,
//			Integer order_id, Order order) {
//		super();
//		this.cart_id = cart_id;
//		this.product_id = product_id;
//		this.product = product;
//		this.user_id = user_id;
//		this.orderObj = orderObj;
//		this.user = user;
//		this.order_id = order_id;
//		this.order = order;
//	}
//
//
//	
//	

}
