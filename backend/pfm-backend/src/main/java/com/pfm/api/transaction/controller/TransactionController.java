package com.pfm.api.transaction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfm.api.transaction.model.TransactionModel;
import com.pfm.api.transaction.service.ITransactionService;

@RestController
@RequestMapping(path = "/api/transaction")
public class TransactionController {

	@Autowired
	ITransactionService service;

	@GetMapping(path = "/listAll")
	public ResponseEntity<List<TransactionModel>> listAll() {
		List<TransactionModel> transactions = service.findAll();
		return new ResponseEntity<>(transactions, HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<TransactionModel> getById(@PathVariable Integer id) {
		TransactionModel response = this.service.getById(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

//    @GetMapping("/search")
//    public ResponseEntity<List<Transaction> search(@RequestParam("description") String description) {
//        List<Transaction> transactions = transactionService.searchByDescription(description);
//        return new ResponseEntity<>(transactions, HttpStatus.OK);
//    }
//
	@PostMapping
	public ResponseEntity<TransactionModel> save(@RequestBody TransactionModel model) {
		TransactionModel response = this.service.saveOrUpdate(model);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}


    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
    	Boolean response = this.service.deleteById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
