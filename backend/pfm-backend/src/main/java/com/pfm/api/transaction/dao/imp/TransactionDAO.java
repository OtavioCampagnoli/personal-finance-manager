package com.pfm.api.transaction.dao.imp;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pfm.api.transaction.dao.ITransactionDAO;
import com.pfm.api.transaction.model.TransactionModel;

@Repository
public class TransactionDAO implements ITransactionDAO {	
	
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
		// TODO Auto-generated method stub
		return null;
	}
}
