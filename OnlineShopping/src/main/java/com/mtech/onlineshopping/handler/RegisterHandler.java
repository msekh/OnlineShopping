package com.mtech.onlineshopping.handler;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mtech.onlineshopping.model.RegisterModel;
import com.mtech.shoppingBackEnd.dao.UserDAO;
import com.mtech.shoppingBackEnd.dto.Address;
import com.mtech.shoppingBackEnd.dto.Cart;
import com.mtech.shoppingBackEnd.dto.User;



@Component
public class RegisterHandler implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UserDAO userDAO;
	
	public RegisterModel init() {
		return new RegisterModel();
	}

	public void addUser(RegisterModel registerModel, User user) {
		registerModel.setUser(user);
	}

	public void addBilling(RegisterModel registerModel, Address billing) {
		registerModel.setBilling(billing);
	}
	public String saveAll(RegisterModel model) {
		String transitionValue="success";
		//fetch the User
		User user=model.getUser();
		
		if(user.getRole().equals("USER")) {
			Cart cart=new Cart();
			cart.setUser(user);
			user.setCart(cart);
		}
		//save the User
		
		userDAO.addUser(user);
		//get the address
		
		Address billing=model.getBilling();
		billing.setUserId(user.getId());
		billing.setBilling(true);
		//save the Address
		userDAO.addAddress(billing);
		return transitionValue;
		
	}
}
