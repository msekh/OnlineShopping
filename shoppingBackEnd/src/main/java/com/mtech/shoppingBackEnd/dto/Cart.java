package com.mtech.shoppingBackEnd.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Cart {

	/*private field*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY , generator = "cart_id_Sequence")
	@SequenceGenerator( allocationSize=1, initialValue=1, name = "cart_id_Sequence", sequenceName = "cart_seq")
	private int id;
//	@Column(name="user_id")
//	private int userId;
	//--------------------//
	@OneToOne
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	//--------------------//
	@Column(name="cart_lines")
	private int cartLines;
	@Column(name="grand_total")
	private double grandTotal;
	
	/*getter and setter*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCartLines() {
		return cartLines;
	}
	public void setCartLines(int cartLines) {
		this.cartLines = cartLines;
	}
	public double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	/*for debugging and logging activity*/
	@Override
	public String toString() {
		return "Cart [id=" + id + ", cartLines=" + cartLines + ", grandTotal=" + grandTotal
				+ "]";
	}
	
	
	
}
