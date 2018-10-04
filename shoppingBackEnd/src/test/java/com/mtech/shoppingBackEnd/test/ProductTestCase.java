package com.mtech.shoppingBackEnd.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mtech.shoppingBackEnd.dao.ProductDAO;
import com.mtech.shoppingBackEnd.dto.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private Product product;

	@BeforeClass
	public static void inti() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.mtech.shoppingBackEnd");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
	}

	@Test
	public void testCRUDProduct() {
		// create operation
		product = new Product();

		product.setName(" Selfie S53");
		product.setBrand("Oppo");
		product.setDescription("This is some description for oppo mobile phones!");
		product.setUnitPrice(25000);
		product.setQuantity(6);
		product.setActive(true);
		product.setCategoryId(104);
		product.setSupplierId(18);

		assertEquals("Something went wrong while inserting a new product!", true, productDAO.add(product));

		product = new Product();

		product.setName("iPhone ");
		product.setBrand("apple");
		product.setDescription("This is some description for oppo mobile phones!");
		product.setUnitPrice(25000);
		product.setQuantity(5);
		product.setActive(true);
		product.setCategoryId(104);
		product.setSupplierId(18);
		
		assertEquals("Something went wrong while inserting a new product!", true, productDAO.add(product));
		
		product = new Product();

		product.setName("Sony TV");
		product.setBrand("SONY");
		product.setDescription("This is some description for SONY TV!");
		product.setUnitPrice(25000);
		product.setQuantity(3);
		product.setActive(true);
		product.setCategoryId(102);
		product.setSupplierId(18);
		assertEquals("Something went wrong while inserting a new product!", true, productDAO.add(product));
		
		product = new Product();
	
		product.setName("LapTop");
		product.setBrand("HP");
		product.setDescription("This is some description for HP!");
		product.setUnitPrice(25000);
		product.setQuantity(4);
		product.setActive(true);
		product.setCategoryId(103);
		product.setSupplierId(18);
		assertEquals("Something went wrong while inserting a new product!", true, productDAO.add(product));
		
		// reading and updating the category
//		product = productDAO.get(2);
//		product.setName("Samsung Galaxy S7");
//		assertEquals("Something went wrong while updating the existing record!", true, productDAO.update(product));

		//assertEquals("Something went wrong while deleting the existing record!", true, productDAO.delete(product));

		// list
		assertEquals("Something went wrong while fetching the list of products!",4, productDAO.list().size());

	}
//	@Test
//	public void testListActiveProducts() {
//		assertEquals("Something went wrong while fetching the list of products!", 8,
//				productDAO.listActiveProducts().size());
//	}
//	@Test
//	public void testListActiveProductsCategory() {
//		assertEquals("Something went wrong while fetching the list of products!", 6,
//				productDAO.listActiveProductsByCategory(3).size());
//		assertEquals("Something went wrong while fetching the list of products!", 1,
//				productDAO.listActiveProductsByCategory(2).size());
//		assertEquals("Something went wrong while fetching the list of products!",1,
//				productDAO.listActiveProductsByCategory(1).size());
//	}
//	
//	@Test
//	public void testGetLatestActiveProduct() {
//		assertEquals("Something went wrong while fetching the list of products!",4,
//				productDAO.getLatestActiveProducts(4).size());
//	}
//	
}
