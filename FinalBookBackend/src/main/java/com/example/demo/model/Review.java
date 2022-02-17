package com.example.demo.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;



@Entity
public class Review 
{
	@Id
	String reviewid;
	@Column
	String bookid ;
	@Column
	String custid;
	@Column
	String comment;
	@Column
	String reviewdate;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bookid", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Book book;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "custid", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Customer customer;
	
	public Review(String reviewid, String bookid, String customerid, String comment, String reviewdate) {
		super();
		this.reviewid = reviewid;
		this.bookid = bookid;
		this.custid = customerid;
		this.comment = comment;
		this.reviewdate = reviewdate;
	}

	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Review [reviewid=" + reviewid + ", bookid=" + bookid + ", customerid=" + custid + ", comment="
				+ comment + ", reviewdate=" + reviewdate + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookid, comment, custid, reviewdate, reviewid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Review other = (Review) obj;
		return Objects.equals(bookid, other.bookid) && Objects.equals(comment, other.comment)
				&& Objects.equals(custid, other.custid) && Objects.equals(reviewdate, other.reviewdate)
				&& Objects.equals(reviewid, other.reviewid);
	}

	public String getReviewid() {
		return reviewid;
	}

	public void setReviewid(String reviewid) {
		this.reviewid = reviewid;
	}

	public String getBookid() {
		return bookid;
	}

	public void setBookid(String bookid) {
		this.bookid = bookid;
	}

	public String getCustomerid() {
		return custid;
	}

	public void setCustomerid(String customerid) {
		this.custid = customerid;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getReviewdate() {
		return reviewdate;
	}

	public void setReviewdate(String reviewdate) {
		this.reviewdate = reviewdate;
	}
}