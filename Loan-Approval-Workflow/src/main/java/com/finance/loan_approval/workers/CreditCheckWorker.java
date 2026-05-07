package com.finance.loan_approval.workers;

import java.util.Map;

import org.springframework.stereotype.Component;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.JobWorker;

@Component
public class CreditCheckWorker {

	@JobWorker(type="credit-check")
	public Map<String,Object> checkCredit(ActivatedJob job){
		
		var variables = job.getVariablesAsMap();
		String customerId = (String) variables.getOrDefault("customerId", "UNKNOWN");
		int creditScore = (int) variables.getOrDefault("creditScore", 0);
		int loanAmount = (int) variables.getOrDefault("loanAmount", 0);
		System.out.println("Running Credit check for: "+customerId);
		System.out.println("Credit Score: "+ creditScore);
		
		boolean validCreditCheck= creditScore>0 && loanAmount>0;
		System.out.println("ValidCreditCheck: "+validCreditCheck);
		
		return Map.of(
				"ValidCreditCheck", validCreditCheck);
	}
}
