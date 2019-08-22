
package com.neha.back.dao;

import java.util.List;

import com.neha.back.dto.Supplier;

public interface SupplierDAO {
	public boolean insertSupp(Supplier supplier);
	public boolean updateSupp(Supplier supplier);
	public boolean deleteSupp(int sid);
	
	
	public Supplier getSupplierById(int id);
	
	public List<Supplier> list();

}