package com.finance.loan_approval.workers;

import java.util.Map;

import org.springframework.stereotype.Component;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.JobWorker;

@Component
public class SendApprovalEmailWorker {
	
	@JobWorker(type="send-approval-email")
	public Map<String, Object> SendApprovalEmail(ActivatedJob job){
		
		var variables = job.getVariablesAsMap();
		
		String customerId = (String) variables.getOrDefault("customerId", "UNKNOWN");
		int loanAmount = (int) variables.getOrDefault("loanAmount", 0);
		
		System.out.println("Sending Approval email to customer: "+customerId +"for loan amount: "+loanAmount);
		
		
		return Map.of("emailSent",true);
	}
}
