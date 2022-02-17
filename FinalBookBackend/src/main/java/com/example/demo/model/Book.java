package com.example.demo.model;
import com.example.demo.model.*;


import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;




@Entity
public class Book {

	
	@Id
	String bookid;
	@Column
	String TITLE;
	@Column
	String AUTHOR;
	@Column
	String CATEGORY;
	@Column
	String PUBLISHER;
	@Column
	boolean IsAvaliable; 
	@Column
	double PRICE;

	@OneToMany(targetEntity = Order.class, mappedBy = "bookid", orphanRemoval = false, fetch = FetchType.LAZY)
	private Set<Order> order;
	
	@OneToMany(targetEntity = Review.class, mappedBy = "bookid", orphanRemoval = false, fetch = FetchType.LAZY)
	private Set<Review> review;
	
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", TITLE=" + TITLE + ", AUTHOR=" + AUTHOR + ", CATEGORY=" + CATEGORY
				+ ", PUBLISHER=" + PUBLISHER + ", IsAvaliable=" + IsAvaliable + ", PRICE=" + PRICE + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(AUTHOR, bookid, CATEGORY, IsAvaliable, PRICE, PUBLISHER, TITLE);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(AUTHOR, other.AUTHOR) && Objects.equals(bookid, other.bookid)
				&& Objects.equals(CATEGORY, other.CATEGORY) && IsAvaliable == other.IsAvaliable
				&& Double.doubleToLongBits(PRICE) == Double.doubleToLongBits(other.PRICE)
				&& Objects.equals(PUBLISHER, other.PUBLISHER) && Objects.equals(TITLE, other.TITLE);
	}
	public String getbookid() {
		return bookid;
	}
	public void setbookid(String Bookid) {
		bookid = Bookid;
	}
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}
	public String getAUTHOR() {
		return AUTHOR;
	}
	public void setAUTHOR(String aUTHOR) {
		AUTHOR = aUTHOR;
	}
	public String getCATEGORY() {
		return CATEGORY;
	}
	public void setCATEGORY(String cATEGORY) {
		CATEGORY = cATEGORY;
	}
	public String getPUBLISHER() {
		return PUBLISHER;
	}
	public void setPUBLISHER(String pUBLISHER) {
		PUBLISHER = pUBLISHER;
	}
	public boolean isIsAvaliable() {
		return IsAvaliable;
	}
	public void setIsAvaliable(boolean isAvaliable) {
		IsAvaliable = isAvaliable;
	}
	public double getPRICE() {
		return PRICE;
	}
	public void setPRICE(double pRICE) {
		PRICE = pRICE;
	}
	
	
	
	
	
}
	