package com.mtech.shoppingBackEnd.dao;

import java.util.List;

import com.mtech.shoppingBackEnd.dto.Address;
import com.mtech.shoppingBackEnd.dto.Cart;
import com.mtech.shoppingBackEnd.dto.User;

public interface UserDAO {
	//add an user
	boolean addUser(User user);
	User getByEmailId(String email);
	//add an address
	boolean addAddress(Address address);
	//Alterative
	//Address getBillingAddress(int userId);
	//List<Address> listShippingAddresses(int userId);
	
	Address getBillingAddress(User user);
	List<Address> listShippingAddresses(User user);
	//Update a Cart
	boolean updateCart(Cart cart);
	
}
