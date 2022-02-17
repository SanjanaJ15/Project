package com.example.demo.model;
import com.example.demo.model.*;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.demo.model.Order;


@Entity()
public class Customer {
	
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private String custid;
	@Column
	private String FirstName;
	@Column
	private String LastName;
	@Column
	private String Email;
	@Column
	private String phno;
	@Column
	private String Username;
	@Column
	private String Password;
	
	@OneToMany(targetEntity = Order.class, mappedBy = "custid", orphanRemoval = false, fetch = FetchType.LAZY)
	private Set<Order> order;
	@OneToMany(targetEntity = Review.class, mappedBy = "custid", orphanRemoval = false, fetch = FetchType.LAZY)
	private Set<Review> review;
	
	
	public String getCusId() {
		return custid;
	}
	public void setCusId(String cusId) {
		custid = cusId;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	@Override
	public int hashCode() {
		return Objects.hash(custid, Email, FirstName, LastName, Password, Username, phno);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(custid, other.custid) && Objects.equals(Email, other.Email)
				&& Objects.equals(FirstName, other.FirstName) && Objects.equals(LastName, other.LastName)
				&& Objects.equals(Password, other.Password) && Objects.equals(Username, other.Username)
				&& Objects.equals(phno, other.phno);
	}
	@Override
	public String toString() {
		return "Customer [CusId=" + custid + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Email=" + Email
				+ ", phno=" + phno + ", Username=" + Username + ", Password=" + Password + ", getCusId()=" + getCusId()
				+ ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName() + ", getEmail()="
				+ getEmail() + ", getPhno()=" + getPhno() + ", getUsername()=" + getUsername() + ", getPassword()="
				+ getPassword() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + ", toString()="
				+ super.toString() + "]";
	}
	public Customer(String cusId, String firstName, String lastName, String email, String phno, String username,
			String password) {
		super();
		custid = cusId;
		FirstName = firstName;
		LastName = lastName;
		Email = email;
		this.phno = phno;
		Username = username;
		Password = password;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
