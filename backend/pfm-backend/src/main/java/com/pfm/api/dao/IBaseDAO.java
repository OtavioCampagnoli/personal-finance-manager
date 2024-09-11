package com.pfm.api.dao;

import java.util.List;

public interface IBaseDAO<T> {

	T save(T entity);

	T update(T entity);

	boolean delete(Long id);

	T getById(Long id);

	List<T> findAll();
	
}
