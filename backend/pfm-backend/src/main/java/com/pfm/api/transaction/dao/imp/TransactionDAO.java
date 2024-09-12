package com.pfm.api.transaction.dao.imp;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.pfm.api.transaction.dao.ITransactionDAO;
import com.pfm.api.transaction.mapper.TransactionMapper;
import com.pfm.api.transaction.model.TransactionModel;

@Repository
public class TransactionDAO implements ITransactionDAO {

	@Autowired
	NamedParameterJdbcTemplate jdbc;

	private final String schemaName = "personal_finance_manager.";

	@Override
	public TransactionModel save(TransactionModel model) {

		StringBuilder query = new StringBuilder();

		query.append("INSERT INTO " + schemaName + "transaction ");
		query.append("( ");
		query.append("description, ");
		query.append("amount, ");
		query.append("date, ");
		query.append("type, ");
		query.append("category, ");
		query.append("created_at ");
		query.append(") VALUES ( ");
		query.append(":description, ");
		query.append(":amount, ");
		query.append(":date, ");
		query.append(":type, ");
		query.append(":category, ");
		query.append("now() ");
		query.append(" ) ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		params.addValue("description", model.getDescription());
		params.addValue("amount", model.getAmount());
		params.addValue("date", model.getDate());
		params.addValue("type", model.getType().toString());
		params.addValue("category", model.getCategory().toString());

		System.out.println();

		KeyHolder keyHolder = new GeneratedKeyHolder();

		this.jdbc.update(query.toString(), params, keyHolder, new String[] { "id" }); // Certifique-se de que o nome da
																						// coluna está correto

		Number generatedId = keyHolder.getKey();

		if (generatedId != null) {
			model.setId(generatedId.intValue());
		}

		return model;
	}

	@Override
	public TransactionModel update(TransactionModel model) {
		// TODO Auto-generated method stub
		return null;
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
		query.append(" FROM " + this.schemaName + "transaction AS tra ");

		List<TransactionModel> list = this.jdbc.query(query.toString(), new TransactionMapper());

		if (!list.isEmpty()) {
			listReturn.addAll(list);
		}

		return listReturn;
	}
}
