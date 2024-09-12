package com.pfm.api.transaction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

//    @GetMapping("/search")
//    public ResponseEntity<List<Transaction> search(@RequestParam("description") String description) {
//        List<Transaction> transactions = transactionService.searchByDescription(description);
//        return new ResponseEntity<>(transactions, HttpStatus.OK);
//    }
//
//    @PostMapping
//    public ResponseEntity<Transaction> save(@RequestBody Transaction transaction) {
//        Transaction savedTransaction = transactionService.save(transaction);
//        return new ResponseEntity<>(savedTransaction, HttpStatus.CREATED);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Long id) {
//        transactionService.delete(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }

}
