package com.pfm.api.transaction.dao.imp;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pfm.api.transaction.dao.ITransactionDAO;
import com.pfm.api.transaction.mapper.TransactionMapper;
import com.pfm.api.transaction.model.TransactionModel;

@Repository
public class TransactionDAO implements ITransactionDAO {

	@Autowired
	JdbcTemplate jdbc;
			
	private final String schemaName = "personal_finance_manager.";
			
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

		List<TransactionModel> listReturn = new LinkedList<TransactionModel>();

		StringBuilder query = new StringBuilder();
		query.append(" SELECT tra.id, ");
		query.append(" tra.description, ");
		query.append(" tra.amount, ");
		query.append(" tra.date, ");
		query.append(" tra.type, ");
		query.append(" tra.category, ");
		query.append(" tra.created_at, ");
		query.append(" tra.updated_at ");
		query.append(" FROM " + this.schemaName + "transaction AS tra; ");

		List<TransactionModel> list = this.jdbc.query(query.toString(), new TransactionMapper());

		if (!list.isEmpty()) {
			listReturn.addAll(list);
		}

		return listReturn;
	}
}
