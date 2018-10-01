package com.mtech.shoppingBackEnd.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mtech.shoppingBackEnd.dao.CategoryDAO;
import com.mtech.shoppingBackEnd.dto.Category;

/**
 * Unit test for simple App.
 */
public class CategoryTestCase {
	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category;

	@BeforeClass
	public static void inti() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.mtech.shoppingBackEnd");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

//	@Test
//	public void testAddCategory() {
//	    category=new Category();
//		category.setName("TV");
//		category.setDescription("this is some discription of tv ");
//		category.setImageURL("cat.jpg");
//		
//		assertEquals("Add SuccessFully a category inside the table.",true,categoryDAO.add(category));
//	}
	/*
	 * @Test public void testGetCategory() {
	 * 
	 * category=categoryDAO.get(52);
	 * assertEquals(" SuccessFully fetced a category form the  the table.","TV",
	 * category.getName());
	 * 
	 * }
	 */

	/*
	 * @Test public void testUpdateCategory() {
	 * 
	 * category = categoryDAO.get(52); category.setName("Television");
	 * assertEquals(" SuccessFully updated a single category the table.", true,
	 * categoryDAO.update(category));
	 * 
	 * }
	 */

	/*
	 * @Test public void testDeleteteCategory() {
	 * 
	 * category = categoryDAO.get(52);
	 * 
	 * assertEquals(" SuccessFully updated a single category the table.", true,
	 * categoryDAO.delete(category));
	 * 
	 * }
	 */

	/*
	 * @Test public void testListCategory() {
	 * 
	 * //category = categoryDAO.get(52);
	 * 
	 * assertEquals(" SuccessFully fetched list category from the table.",1,
	 * categoryDAO.list().size());
	 * 
	 * }
	 */
	@Test
	public void testCRUDCategory() {

		// Add category
		category = new Category();
		
		category.setName("TV");
		category.setDescription("this is some discription of TV ");
		category.setImageURL("cat_100.jpg");

		assertEquals("Add SuccessFully a category inside the table.", true, categoryDAO.add(category));

		category = new Category();

		category.setName("Laptop");
		category.setDescription("this is some discription of laptop ");
		category.setImageURL("cat_100.jpg");

		assertEquals("Add SuccessFully a category inside the table.", true, categoryDAO.add(category));

		category = new Category();

		category.setName("Mobile");
		category.setDescription("this is some discription of Mobile ");
		category.setImageURL("cat_101.jpg");

		assertEquals("Add SuccessFully a category inside the table.", true, categoryDAO.add(category));

		category = new Category();

		category.setName("Radio");
		category.setDescription("this is some discription of Radio ");
		category.setImageURL("cat_102.jpg");

		assertEquals("Add SuccessFully a category inside the table.", true, categoryDAO.add(category));

		// fetching category
		category = categoryDAO.get(1);
		assertEquals(" SuccessFully fetced a category form the  the table.", "TV", category.getName());

		// Delete category
		//assertEquals(" SuccessFully delete a single category the table.", true, categoryDAO.delete(category));
		// Fetching List
		assertEquals(" SuccessFully fetched list category from the table.",7, categoryDAO.list().size());

	}
}
