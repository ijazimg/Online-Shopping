package com.infoTech.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.infoTech.shoppingbackend.dao.ProductDAO;
import com.infoTech.shoppingbackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImp implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Single proudcts
	 */
	@Override
	public Product get(int productId) {
		try {
			return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(productId));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * List of proudcts
	 */

	@Override
	public List<Product> list() {
		try {
			return sessionFactory.getCurrentSession().createQuery("From Product", Product.class).getResultList();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * Insert into Proudcts
	 */
	@Override
	public boolean add(Product product) {
		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Update Product Table
	 */
	@Override
	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return false;
	}

	/**
	 * Delete from product Table
	 */

	@Override
	public boolean delete(Product product) {
		try {
			sessionFactory.getCurrentSession().delete(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Product> getProductsByParam(String param, int count) {
		String getProductByParam = "From product Where active = true Order by " + param + "DESE";
		return sessionFactory.getCurrentSession().createQuery(getProductByParam, Product.class).setFirstResult(0)
				.setMaxResults(count).getResultList();
	}

	@Override
	public List<Product> listActiveProducts() {
		String listOfActiveProducts = "From Product where active = :active";
		return sessionFactory.getCurrentSession().createQuery(listOfActiveProducts, Product.class)
				.setParameter("active", true).getResultList();

	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String listOfActiveProductsByCategory = "From Product where active = :active AND categoryId = :categoryId";

		return sessionFactory.getCurrentSession().createQuery(listOfActiveProductsByCategory, Product.class)
				.setParameter("active", true).setParameter("categoryId", categoryId).getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {

		return sessionFactory.getCurrentSession()
				.createQuery("From Product where active = :active order by Id", Product.class)
				.setParameter("active", true).setFirstResult(0).setMaxResults(count).getResultList();
	}

}
