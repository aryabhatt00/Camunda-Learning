package com.finance.loan_approval.workers;

import java.util.Map;

import org.springframework.stereotype.Component;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.JobWorker;

@Component
public class RiskManagementWorker {

	@JobWorker(type="risk-management")
	public Map<String,Object> riskManagement (ActivatedJob job) {
		
		var variables = job.getVariablesAsMap();
		int creditScore=(int) variables.getOrDefault("creditScore", 0);
		int loanAmount=(int) variables.getOrDefault("loanAmount", 0);
		String riskLevel="";
		if(loanAmount > 50000 && creditScore<700) riskLevel = "HIGH";
		else if(loanAmount > 20000 && creditScore<650) riskLevel = "MEDIUM";
		else riskLevel="LOW";
		
		return Map.of("riskLevel",riskLevel);
	}
}
