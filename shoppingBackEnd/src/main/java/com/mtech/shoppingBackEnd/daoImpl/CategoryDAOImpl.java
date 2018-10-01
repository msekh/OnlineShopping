package com.mtech.shoppingBackEnd.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mtech.shoppingBackEnd.dao.CategoryDAO;
import com.mtech.shoppingBackEnd.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	@Autowired
	private SessionFactory sessionFactory;
	private static List<Category> categaries = new ArrayList<>();

//	static {
//
//		Category category = new Category();
//
//		category.setId(1);
//		category.setName("TV");
//		category.setDescription("this is some discription of tv ");
//		category.setImageURL("cat.jpg");
//
//		categaries.add(category);
//
//		/* Second category */
//		category = new Category();
//
//		category.setId(2);
//		category.setName("Mobile");
//		category.setDescription("this is some discription of Mb ");
//		category.setImageURL("mb.jpg");
//
//		categaries.add(category);
//
//		/* Third Category */
//
//		category = new Category();
//
//		category.setId(3);
//		category.setName("Laptop");
//		category.setDescription("this is some discription of laptop. ");
//		category.setImageURL("cat2.jpg");
//
//		categaries.add(category);
//
//	}

	@Override
	public List<Category> list() {
		String selectActiveCategory = "FROM Category WHERE active = :active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		return query.getResultList();
	}

	/*
	 * 
	 * Getting Single Category Based on ID
	 * 
	 * @see com.mtech.shoppingBackEnd.dao.CategoryDAO#get(int)
	 */
	@Override
	public Category get(int id) {
//		// ebhance for loop
//		for (Category category : categaries) {
//			if (category.getId() == id)
//				return category;
//		}
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	@Transactional
	public boolean add(Category category) {
		//category.setActive(true);
		try {
			// add the category to the database
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	/*
	 * Udating a single category
	 */
	@Override
	public boolean update(Category category) {
		try {
			// add the category to the database
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {

		category.setActive(false);
		try {
			// add the category to the database
			sessionFactory.getCurrentSession().delete(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
