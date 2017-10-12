package com.infoTech.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.RespectBinding;

import org.springframework.stereotype.Repository;

import com.infoTech.shoppingbackend.dao.CategoryDAO;
import com.infoTech.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();

	static {

		Category category = new Category();

		// ading frist cat
		category.setId(1);
		category.setName("television");
		category.setDescription("description for Televeion");
		category.setImageUrl("CAT_1.PNG");

		categories.add(category);

		// ading second cat
		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("description for mobile");
		category.setImageUrl("CAT_2.PNG");

		categories.add(category);

		// ading third cat
		category = new Category();
		category.setId(3);
		category.setName("telephone");
		category.setDescription("description for Telephone");
		category.setImageUrl("CAT_3.PNG");

		categories.add(category);
	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		// using for each loop

		for (Category category : categories) {

			if (category.getId() == id) {
				return category;
			}

		}
		return null;
	}

}
