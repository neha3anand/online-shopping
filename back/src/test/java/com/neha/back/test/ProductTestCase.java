package com.neha.back.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.neha.back.dao.ProductDAO;
import com.neha.back.dto.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private Product product;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.neha.back");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
	}

	/*
	 * @Test public void testCRUDProduct() { product = new Product();
	 * 
	 * product.setName("oppo selfie"); product.setBrand("oppo");
	 * product.setDescription("good mob"); product.setUnitPrice(25000);
	 * product.setActive(true); product.setCategoryId(2); product.setSupplierId(3);
	 * 
	 * assertEquals("something went wrong while inserting",true,productDAO.add(
	 * product));
	 * 
	 * product = productDAO.get(2); product.setName("samsung galaxy s7");
	 * assertEquals("something went wrong while updating",true,productDAO.update(
	 * product));
	 * 
	 * assertEquals("something went wrong while deleting",true,
	 * productDAO.delete(product));
	 * 
	 * assertEquals("something went wrong while fetching",4,
	 * productDAO.list().size());
	 * 
	 * }
	 */
	@Test
	public void testListActiveProducts() {

		assertEquals("something went wrong while fetching", 3, productDAO.listActiveProducts().size());

	}

	@Test
	public void testListActiveProductsByCategory() {

		assertEquals("something went wrong while fetching", 2, productDAO.listActiveProductsByCategory(1).size());
		assertEquals("something went wrong while fetching", 1, productDAO.listActiveProductsByCategory(2).size());

	}

	@Test
	public void testGetLatestActiveProduct() {

		assertEquals("something went wrong while fetching", 3, productDAO.getLatestActiveProducts(3).size());

	}
}
