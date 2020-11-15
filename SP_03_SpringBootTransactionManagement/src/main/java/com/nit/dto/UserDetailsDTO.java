package com.nit.dto;

public class UserDetailsDTO {
	
	private long accno;
	private String username;
	private String password;
	private double balance;
	public long getAccno() {
		return accno;
	}
	public void setAccno(long accno) {
		this.accno = accno;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "UserDetailsDTO [accno=" + accno + ", username=" + username + ", password=" + password + ", balance="
				+ balance + "]";
	}
	
	

}
