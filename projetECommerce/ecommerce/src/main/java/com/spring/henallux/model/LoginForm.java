package com.spring.henallux.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginForm {
	@NotEmpty
	private String pseudoLogin;
	@Size(min=6,max=25)
	private String passwordLogin;
	
	public String getPseudoLogin() {
		return pseudoLogin;
	}

	public void setPseudoLogin(String pseudoLogin) {
		this.pseudoLogin = pseudoLogin;
	}

	public String getPasswordLogin() {
		return passwordLogin;
	}

	public void setPasswordLogin(String passwordLogin) {
		this.passwordLogin = passwordLogin;
	}

	public LoginForm(){
		
	}

}
