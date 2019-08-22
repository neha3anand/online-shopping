package com.neha.back.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.neha.back.dao.CategoryDAO;
import com.neha.back.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.neha.back");
		context.refresh();

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	/*
	 * @Test public void testAddCategory() { category = new Category();
	 * 
	 * category.setName("Laptop"); category.setDescription("apple");
	 * category.setImageURL("");
	 * 
	 * assertEquals("successfully added", true, categoryDAO.add(category));
	 * 
	 * }
	 */
	/*
	 * @Test public void testGetCategory() {
	 * 
	 * category = categoryDAO.get(1);
	 * assertEquals("successfully fetched","Television", category.getName()); }
	 */
	/*
	 * @Test public void testUpdateCategory() {
	 * 
	 * category = categoryDAO.get(1); category.setName("tv");
	 * assertEquals("successfully updated",true,categoryDAO.update(category)); }
	 */

	/*
	 * @Test public void testDeleteCategory() {
	 * 
	 * category = categoryDAO.get(1);
	 * assertEquals("successfully deleted",true,categoryDAO.delete(category)); }
	 */

	/*
	 * @Test public void testListCategory() {
	 * 
	 * category = categoryDAO.get(1);
	 * assertEquals("successfully fetched list",1,categoryDAO.list().size()); }
	 */

	@Test
	public void testCRUDCategory() {
		category = new Category();
		category.setName("Laptop");
		category.setDescription("apple");
		category.setImageURL("");
		assertEquals("successfully added", true, categoryDAO.add(category));

		category = new Category();
		category.setName("Television");
		category.setDescription("lcd");
		category.setImageURL("");
		assertEquals("successfully added", true, categoryDAO.add(category));

		category = categoryDAO.get(2);
		category.setName("tv");
		assertEquals("successfully updated", true, categoryDAO.update(category));

		assertEquals("successfully deleted", true, categoryDAO.delete(category));

		assertEquals("successfully fetched list", 1, categoryDAO.list().size());
	}

}
