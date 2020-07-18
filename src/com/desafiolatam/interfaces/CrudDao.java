package com.desafiolatam.interfaces;

import java.util.List;

public interface CrudDao {
	public boolean insert(Object objeto);
	public List selectAll();
	public Object selectById(Object objeto);
	public boolean update(Object objeto);
	public boolean delete(Object objeto);
}
