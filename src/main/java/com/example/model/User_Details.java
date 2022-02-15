package com.example.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="UserDetails")
public class User_Details 

{
	@Id
    @GeneratedValue
    @Column(name = "User_DetailID", length = 50)
    private Integer id;
   
	@OneToOne(cascade = CascadeType.ALL)
	private User user;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Cart cart;
 
   @Column(name="Street_Address")
	private String street;
   @Column(name="city")
 	private String city;
    
   @Column(name="state")
 	private String state;
    
   @Column(name="country")
 	private String country;
   @Column(name="zipcode")
	private String zipcode;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public Cart getCart() {
	return cart;
}
public void setCart(Cart cart) {
	this.cart = cart;
}
public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getZipcode() {
	return zipcode;
}
public void setZipcode(String zipcode) {
	this.zipcode = zipcode;
}
public User_Details(Integer id, User user, Cart cart, String street, String city, String state, String country,
		String zipcode) {
	super();
	this.id = id;
	this.user = user;
	this.cart = cart;
	this.street = street;
	this.city = city;
	this.state = state;
	this.country = country;
	this.zipcode = zipcode;
}
public User_Details() {
}
@Override
public String toString() {
	return "User_Details [id=" + id + ", user=" + user + ", cart=" + cart + ", street=" + street + ", city=" + city
			+ ", state=" + state + ", country=" + country + ", zipcode=" + zipcode + "]";
}
    
   
//	cart id,userid,address (country,city,street)

}
