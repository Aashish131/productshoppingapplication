package com.example.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "USER")
public class User implements Serializable {

	private static final long serialVersionUID = -2054386655979281969L;
//
//	public static final String ROLE_ADMIN = "ADMIN";
//	public static final String ROLE_CUSTOMER = "CUSTOMER";

	
	
	
	
	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	private Integer user_Id;

	@Email(message = "email is not valid")
	@NotNull
	@Column(name = "EMAIL_ID")
	private String email;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	 
	@NotEmpty
	@Size(min = 4, message = "User password should be Atleast 4")
	@Column(name = "PASSWORD")
	private String password;

	
	    
	@Column(name="User_Role")
	 private String roles;

	public String getRoles() {
			return roles;
		}

		public void setRoles(String roles) {
			this.roles = roles;
		}

	public Integer getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(Integer user_Id) {
		this.user_Id = user_Id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
    public User() {
        
    }

	public User(Integer user_Id, @NotNull String email, String firstName, String lastName,
			String password,String role) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.roles=role;
	}

	@Override
	public String toString() {
		return "User [user_Id=" + user_Id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + ", role=" + roles + "]";
	}

	

	

//	@Id
//	@Column(name = "User_Name", length = 40, nullable = false)
//	private String userName;
//
//	@Column(name = "Password", length = 128, nullable = false)
//	private String Password;
//
//	@Column(name = "Active", length = 1, nullable = false)
//	private String active;
//
//	@Column(name = "User_Role", length = 20, nullable = false)
//	private String userRole;

}
