package com.neha.back.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.neha.back.dao.SupplierDAO;
import com.neha.back.dto.Supplier;

public class SupplierTestCase {

	private static AnnotationConfigApplicationContext context;
	private static SupplierDAO supplierDAO;
	private Supplier supplier = null;
	
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.neha.back");
		context.refresh();
		
		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
	}

	@Test
	public void testAddSupplier() {
		supplier=new Supplier();
		
		supplier.setSupplierName("Neha");
		
		
				assertEquals("Failed to add the supplier!", true, supplierDAO.insertSupp(supplier));	
	}
	@Ignore
	@Test
	public void testUpdateSupplier() {
		supplier=new Supplier();
		supplier.setSid(1);
		supplier.setSupplierName("Neha Anand");
		
		
				assertEquals("Failed to update the supplier!", true, supplierDAO.updateSupp(supplier));	
	}
	@Ignore
	@Test
	public void testDeleteSupplier() {
		
		
		
				assertEquals("Failed to delete the supplier!", true, supplierDAO.deleteSupp(1));	
	}

}