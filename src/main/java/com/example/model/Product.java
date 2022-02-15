package com.example.model;


import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;



@Entity
@Table(name="Products")
public class Product implements Serializable {
   
   private static final long serialVersionUID = -1000119078147252957L;
   
         @Id
         @GeneratedValue
       @Column(name = "Product_Code", length = 20, nullable = false)
       private Integer code;
    
       @Column(name = "Product_Name", length = 255, nullable = false)
       private String name;
    
       @Column(name = "Product_Price", nullable = false)
       private double price;
    
       @Lob
       @Column(name = "Product_Image", length = Integer.MAX_VALUE, nullable = true)
       private byte[] image;
        
       @Column(name = "Product_Description", length = 255, nullable = false)
       private String description;
    
       @Column(name = "Product_Quantity", nullable = false)
       private int quantity;
       
       @Column(name = "Product_Type", length = 255, nullable = false)
       private String productType;
    
     




       public Integer getCode() {
		return code;
	}






	public void setCode(Integer code) {
		this.code = code;
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






	public byte[] getImage() {
		return image;
	}






	public void setImage(byte[] image) {
		this.image = image;
	}






	public String getDescription() {
		return description;
	}






	public void setDescription(String description) {
		this.description = description;
	}






	public int getQuantity() {
		return quantity;
	}






	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}






	public String getProductType() {
		return productType;
	}






	public void setProductType(String productType) {
		this.productType = productType;
	}






	public Product() {
           // TODO Auto-generated constructor stub
       }






	public Product(Integer code, String name, double price, byte[] image, String description, int quantity,
			String productType) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.image = image;
		this.description = description;
		this.quantity = quantity;
		this.productType = productType;
	}






	@Override
	public String toString() {
		return "Product [code=" + code + ", name=" + name + ", price=" + price + ", image=" + Arrays.toString(image)
				+ ", description=" + description + ", quantity=" + quantity + ", productType=" + productType + "]";
	}
       
       



}
