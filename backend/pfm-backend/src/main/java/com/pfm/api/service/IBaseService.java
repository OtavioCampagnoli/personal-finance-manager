package com.pfm.api.service;

import java.util.List;

public interface IBaseService<T> {

	T save(T entity);

	T update(T entity);
	
	T saveOrUpdate(T entity);

	boolean delete(Long id);

	T getById(Long id);

	List<T> findAll();

}
