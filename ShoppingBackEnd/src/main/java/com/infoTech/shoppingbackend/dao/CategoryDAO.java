package com.infoTech.shoppingbackend.dao;

import java.util.List;

import com.infoTech.shoppingbackend.dto.Category;

public interface CategoryDAO {

	List<Category> list();

	Category get(int id);
}
