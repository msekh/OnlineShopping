package com.mtech.shoppingBackEnd.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;


@Entity
public class Address implements Serializable{
	private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY, generator = "address_id_Sequence")
@SequenceGenerator(allocationSize=1, initialValue=1, name = "address_id_Sequence", sequenceName = "address_seq")
private int id;

@Column(name="address_line_one")
private String addressLineOne;
@Column(name="address_line_two")
private String addressLineTwo;
private String city;
private String division;
private String country;
@Column(name="postal_code")
private String postalCode;
@Column(name="is_billing")
private boolean billing;
@Column(name="is_shipping")
private boolean shipping;

//setter and getter
private int userId;

public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
/*---------------*/
@ManyToOne
private User user;

public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
//-------------------//
public String getAddressLineOne() {
	return addressLineOne;
}
public void setAddressLineOne(String addressLineOne) {
	this.addressLineOne = addressLineOne;
}
public String getAddressLineTwo() {
	return addressLineTwo;
}
public void setAddressLineTwo(String addressLineTwo) {
	this.addressLineTwo = addressLineTwo;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getDivision() {
	return division;
}
public void setDivision(String division) {
	this.division = division;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getPostalCode() {
	return postalCode;
}
public void setPostalCode(String postalCode) {
	this.postalCode = postalCode;
}
public boolean isBilling() {
	return billing;
}
public void setBilling(boolean billing) {
	this.billing = billing;
}
public boolean isShipping() {
	return shipping;
}
public void setShipping(boolean shipping) {
	this.shipping = shipping;
}

/*for debugging and logging activity*/
@Override
public String toString() {
	return "Address [id=" + id + ", addressLineOne=" + addressLineOne + ", addressLineTwo=" + addressLineTwo + ", city="
			+ city + ", division=" + division + ", country=" + country + ", postalCode=" + postalCode + ", billing="
			+ billing + ", shipping=" + shipping + ", userId=" + userId + ", user=" + user + "]";
}






}
