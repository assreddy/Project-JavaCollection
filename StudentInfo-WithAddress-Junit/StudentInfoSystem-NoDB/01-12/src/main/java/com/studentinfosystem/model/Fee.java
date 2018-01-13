package com.studentinfosystem.model;

public class Fee {
	double totalFee;
	double frirstTerm;
	double secondTerm;
	double thirdTerm;
	
	public Fee() {
	}
	
	public Fee(double totalFee, double frirstTerm, double secondTerm, double thirdTerm) {
		super();
		this.totalFee = totalFee;
		this.frirstTerm = frirstTerm;
		this.secondTerm = secondTerm;
		this.thirdTerm = thirdTerm;
	}
	
	public double getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(double totalFee) {
		this.totalFee = totalFee;
	}
	public double getFrirstTerm() {
		return frirstTerm;
	}
	public void setFrirstTerm(double frirstTerm) {
		this.frirstTerm = frirstTerm;
	}
	public double getSecondTerm() {
		return secondTerm;
	}
	public void setSecondTerm(double secondTerm) {
		this.secondTerm = secondTerm;
	}
	public double getThirdTerm() {
		return thirdTerm;
	}
	public void setThirdTerm(double thirdTerm) {
		this.thirdTerm = thirdTerm;
	}
}
