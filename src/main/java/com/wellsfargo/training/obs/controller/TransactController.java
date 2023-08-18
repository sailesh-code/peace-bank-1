package com.wellsfargo.training.obs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.training.obs.model.Transact;
import com.wellsfargo.training.obs.service.TransactService;

@RestController
@RequestMapping("/api")
public class TransactController {

	@Autowired
	private TransactService tservice;
	
	@PostMapping("/transaction")
	public ResponseEntity <String> createTransact(@Validated @RequestBody Transact transact){
		
		Transact registertransact = tservice.registerTransact(transact);
		
		if(registertransact != null) {
			return ResponseEntity.ok("Transaction Successfull");
		}
		else {
			return ResponseEntity.badRequest().body("Transaction Failed");
		}
	}
}
