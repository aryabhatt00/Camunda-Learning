package com.finance.loan_approval.model;


public class LoanApplication {

	private String customerId;
	private int creditScore;
	private int loanAmount;
	
	
	
	
	public LoanApplication(String customerId, int creditScore, int loanAmount) {
		super();
		this.customerId = customerId;
		this.creditScore = creditScore;
		this.loanAmount = loanAmount;
	}
	@Override
	public String toString() {
		return "LoanApplication [customerId=" + customerId + ", creditScore=" + creditScore + ", loanAmount="
				+ loanAmount + "]";
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public int getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}
	public int getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}
	
	
}
