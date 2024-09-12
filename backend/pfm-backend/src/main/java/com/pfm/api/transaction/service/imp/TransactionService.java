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
	public TransactionModel save(TransactionModel model) {
		return this.dao.save(model);
	}

	@Override
	public TransactionModel update(TransactionModel model) {
		return this.dao.update(model);
	}

	@Override
	public TransactionModel saveOrUpdate(TransactionModel model) {

		if (model == null) {
			throw new IllegalArgumentException("Transaction model cannot be null");
		}

		if (model.getId() != null && model.getId() > 0) {
			return this.update(model);
		}

		return this.save(model);
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TransactionModel getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TransactionModel> findAll() {
		return this.dao.findAll();
	}

}
