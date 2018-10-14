package com.mtech.shoppingBackEnd.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mtech.shoppingBackEnd.dao.UserDAO;
import com.mtech.shoppingBackEnd.dto.Address;
import com.mtech.shoppingBackEnd.dto.Cart;
import com.mtech.shoppingBackEnd.dto.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addUser(User user) {
		try {
			sessionFactory.getCurrentSession().persist(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean addAddress(Address address) {
		try {
			sessionFactory.getCurrentSession().persist(address);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public User getByEmailId(String email) {
		String selectQuery="FROM User where email = :email ";
		try {
			return sessionFactory.getCurrentSession().createQuery(selectQuery, User.class)
					.setParameter("email", email)
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Address getBillingAddress(User user) {
		String selectQuery="FROM Address where user = :user and billing = :billing ";
		try {
			return sessionFactory.getCurrentSession().createQuery(selectQuery, Address.class)
					.setParameter("user",user)
					.setParameter("billing", true)
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Address> listShippingAddresses(User user) {
		String selectQuery="FROM Address where user = :user and shipping = :shipping ";
		try {
			return sessionFactory.getCurrentSession().createQuery(selectQuery, Address.class)
					.setParameter("user",user)
					.setParameter("shipping", true)
					.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


}
