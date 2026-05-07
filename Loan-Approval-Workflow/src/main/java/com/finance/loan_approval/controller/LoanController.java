package com.finance.loan_approval.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finance.loan_approval.model.LoanApplication;

import io.camunda.zeebe.client.ZeebeClient;

@RestController
@RequestMapping("/api/loans")
public class LoanController {
	
	@Autowired
	private ZeebeClient zeebeClient;
	
	@PostMapping("/apply")
	public ResponseEntity<String> applyLoan(@RequestBody LoanApplication application){
		
		zeebeClient.newCreateInstanceCommand()
					.bpmnProcessId("loan-approval")
					.latestVersion()
					.variables(Map.of(
							"customerId", application.getCustomerId(),
							"creditScore", application.getCreditScore(),
							"loanAmount", application.getLoanAmount()
							)).send();
		
		return ResponseEntity.ok("Loan Application submitted for : "+application.getCustomerId());
	}

	
}
