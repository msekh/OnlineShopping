package com.mtech.shoppingBackEnd.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mtech.shoppingBackEnd.dao.UserDAO;
import com.mtech.shoppingBackEnd.dto.Address;
import com.mtech.shoppingBackEnd.dto.Cart;
import com.mtech.shoppingBackEnd.dto.User;

public class UserTestCase {
	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Cart cart = null;
	private Address address = null;

	@BeforeClass
	public static void inti() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.mtech");
		context.refresh();
		userDAO = (UserDAO) context.getBean("userDAO");
	}

	/*
	 * @Test public void testUser() { user = new User(); user.setFirstName("Shekh");
	 * user.setLastName("RUpon"); user.setEmail("hr@gmail.com");
	 * user.setContactNumber("0171012012"); user.setRole("USER");
	 * user.setEnabled(true); user.setPassword("12345");
	 * assertEquals("failed to add user", true, userDAO.addUser(user)); // add
	 * Address address = new Address(); address.setAddressLineOne("Udaypur");
	 * address.setAddressLineTwo("Near High School"); address.setCity("Bhola");
	 * address.setDivision("Barisal"); address.setCountry("Bangladesh");
	 * address.setPostalCode("8320"); address.setBilling(true);
	 * 
	 * // link the user with the Address using user Id
	 * address.setUserId(user.getId()); assertEquals("failed to add Address", true,
	 * userDAO.addAddress(address));
	 * 
	 * if(user.getRole().equals("USER")) { cart=new Cart(); cart.setUser(user);
	 * //add the cart assertEquals("failed to add Address", true,
	 * userDAO.addCart(cart));
	 * 
	 * // add shipping address for this user address = new Address();
	 * address.setAddressLineOne("Udaypur");
	 * address.setAddressLineTwo("Near High School"); address.setCity("Bhola");
	 * address.setDivision("Barisal"); address.setCountry("Bangladesh");
	 * address.setPostalCode("8320"); //set Shipping address.setShipping(true);
	 * //link it with the user address.setUserId(user.getId()); //add shipping
	 * address assertEquals("failed to add shipping  Address", true,
	 * userDAO.addAddress(address)); } }
	 */
	/*
	 * @Test public void testUser() { user = new User(); user.setFirstName("Shekh");
	 * user.setLastName("RUpon"); user.setEmail("hr@gmail.com");
	 * user.setContactNumber("0171012012"); user.setRole("USER");
	 * user.setEnabled(true); user.setPassword("12345");
	 * 
	 * if (user.getRole().equals("USER")) { //create a cart for this user cart = new
	 * Cart(); cart.setUser(user); //attached cart with user user.setCart(cart);
	 * 
	 * } assertEquals("failed to add user", true, userDAO.addUser(user)); }
	 */
	/*
	 * @Test public void testUpdateCart() { //fetch the user by email user =
	 * userDAO.getByEmailId("hr@gmail.com"); //get the cart of the user
	 * cart=user.getCart(); cart.setGrandTotal(55555); cart.setCartLines(2);
	 * 
	 * assertEquals("Failed to update cart!", true, userDAO.updateCart(cart)); }
	 */

	/*
	 * @Test public void testAddAddress() { //need to add user user = new User();
	 * user.setFirstName("Shekh"); user.setLastName("RUpon");
	 * user.setEmail("hr@gmail.com"); user.setContactNumber("0171012012");
	 * user.setRole("USER"); user.setEnabled(true); user.setPassword("12345"); //
	 * add the user assertEquals("failed to add user", true, userDAO.addUser(user));
	 * 
	 * //we are going to add Address address = new Address();
	 * address.setAddressLineOne("Udaypur");
	 * address.setAddressLineTwo("Near High School"); address.setCity("Bhola");
	 * address.setDivision("Barisal"); address.setCountry("Bangladesh");
	 * address.setPostalCode("8320"); address.setBilling(true);
	 * 
	 * // Attacted the user address.setUser(user);
	 * 
	 * assertEquals("failed to add Address", true, userDAO.addAddress(address)); //
	 * add shipping address address = new Address();
	 * address.setAddressLineOne("Udaypur");
	 * address.setAddressLineTwo("Near High School"); address.setCity("Bhola");
	 * address.setDivision("Barisal"); address.setCountry("Bangladesh");
	 * address.setPostalCode("8320"); //set Shipping address.setShipping(true);
	 * //link it with the user address.setUser(user);
	 * assertEquals("failed to add Shipping Address", true,
	 * userDAO.addAddress(address)); }
	 */
	/*@Test
	public void testAddAddress() {
		user = userDAO.getByEmailId("hr@gmail.com");

		// we are going to add Address
		address = new Address();
		address.setAddressLineOne("1/d/6/d Mirbagh");
		address.setAddressLineTwo("Moghbazar, Dhaka");
		address.setCity("Dhaka");
		address.setDivision("Dhaka");
		address.setCountry("Bangladesh");
		address.setPostalCode("8320");
		address.setShipping(true);

		// Attacted the user
		address.setUser(user);

		assertEquals("failed to add Address", true, userDAO.addAddress(address));
	}*/
	@Test
	public void testGetAddress() {
		user=userDAO.getByEmailId("hr@gmail.com");
		
		assertEquals("failed to fetch the lis of Address and size does not match.",2, 
				userDAO.listShippingAddresses(user).size());
		assertEquals("failed to fetch the billing of Address and size does not match.","Bhola", 
				userDAO.getBillingAddress(user).getCity());
	}
}
