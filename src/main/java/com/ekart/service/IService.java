package com.ekart.service;

import java.util.List;

public interface IService<T> {
	List<T> findAll();
	T findById(final Long id);
	T create(T t);
	boolean delete(final Long id);
	boolean update(T newObj,Long id);
	
	

}
