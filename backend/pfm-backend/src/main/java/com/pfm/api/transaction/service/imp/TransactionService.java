package com.pfm.api.transaction.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfm.api.transaction.dao.ITransactionDAO;
import com.pfm.api.transaction.model.TransactionModel;
import com.pfm.api.transaction.service.ITransactionService;


@Service
public class TransactionService implements ITransactionService {

	@Autowired
	ITransactionDAO dao;
	
	@Override
	public TransactionModel save(TransactionModel entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransactionModel update(TransactionModel entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransactionModel saveOrUpdate(TransactionModel entity) {
		// TODO Auto-generated method stub 
		return null;
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TransactionModel getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TransactionModel> findAll() {
		return this.dao.findAll();
	}

}
