package com.finance.loan_approval.workers;

import java.util.Map;

import org.springframework.stereotype.Component;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.JobWorker;

@Component
public class SendRejectionEmailWorker {
	@JobWorker(type="send-rejection-email")
	public Map<String, Object> SendRejectionEmail(ActivatedJob job){
		
		var variables = job.getVariablesAsMap();
		
		String customerId = (String) variables.getOrDefault("customerId", "UNKNOWN");
		String riskLevel=(String) variables.getOrDefault("riskLevel","NONE" );
		
		System.out.println("Sending Rejection Email to customer: "+customerId+" due to risk level"+riskLevel);
		
		return Map.of(
				"emailSent",true,
				"riskLevel",riskLevel);
	}
}
