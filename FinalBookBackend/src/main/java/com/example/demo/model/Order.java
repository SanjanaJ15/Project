package com.example.demo.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;



@Entity()
@Table(name="orders")
public class Order {


	@Id
	private String orderid;
	@Column
	private String custid;
	@Column
	private String bookid; 
	@Column 
	private int  quantity;
	@Column
	private double amount;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bookid", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Book book;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "custid", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Customer customer;

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getCustid() {
		return custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}

	public String getBookid() {
		return bookid;
	}

	public void setBookid(String bookid) {
		this.bookid = bookid;
	}


	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, book, bookid, custid, customer, orderid, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
				&& Objects.equals(book, other.book) && Objects.equals(bookid, other.bookid)
				&& Objects.equals(custid, other.custid) && Objects.equals(customer, other.customer)
				&& Objects.equals(orderid, other.orderid)
				&&  quantity == other.quantity;
	}

	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", custid=" + custid + ", bookid=" + bookid 
				+ ", quantity=" + quantity + ", amount=" + amount + ", book=" + book + ", customer=" + customer + "]";
	}

	public Order(String orderid, String custid, String bookid, double price, int quantity, double amount, Book book,
			Customer customer) {
		super();
		this.orderid = orderid;
		this.custid = custid;
		this.bookid = bookid;
		this.quantity = quantity;
		this.amount = amount;
		this.book = book;
		this.customer = customer;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}