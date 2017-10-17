package com.infoTech.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.infoTech.shoppingbackend.dao.CategoryDAO;
import com.infoTech.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.infoTech.shoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	/*@Test
	public void testAddCategory() {
		category = new Category();

		category.setName("Laptop");
		category.setDescription("This is some description for laptop!");
		category.setImageUrl("CAT_105.png");
		category.setActive(true);

		assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));
	}*/

	/*@Test
	public void testGetCategory(){
		
		category = categoryDAO.get(1);
		
		assertEquals("Successfully fetched a signle category from the table!", "Laptop", category.getName());
		
		
	}*/
	
	
	/*@Test
	public void testUpdateCategory(){
		
		category = categoryDAO.get(1);
		category.setName("Television");
		assertEquals("Successfully update a signle category in the table!", true, categoryDAO.update(category));
		
		
	}*/
	
	/*@Test
	public void testDeleteCategory(){
		
		category = categoryDAO.get(1);		
		assertEquals("Successfully deleted a signle category in the table!", true, categoryDAO.delete(category));
		
		
		
	}*/
	
	
/*	@Test
	public void testListCategory() {

		assertEquals("Successfully fetched the list of category from the table!", 1, categoryDAO.list().size());

	}*/
	
	
	@Test
	public void crudCrudCategory(){
		//add operation
		category = new Category();

		category.setName("Laptop");
		category.setDescription("This is some description for laptop!");
		category.setImageUrl("CAT_105.png");
		category.setActive(true);
		
		assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));
		
		
		category = new Category();

		category.setName("Mobile");
		category.setDescription("This is some description for Mobile!");
		category.setImageUrl("CAT_105.png");
		category.setActive(true);
		
		assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));
		
		
		// fetchinga and renaming 
		category = categoryDAO.get(2);
		category.setName("Radio");
		assertEquals("Successfully update a signle category in the table!", true, categoryDAO.update(category));
		
		//deleteing category		
		assertEquals("Successfully deleted a signle category in the table!", true, categoryDAO.delete(category));
		
		//fetching list of category
				
	}
	
	
	
}
