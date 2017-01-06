package com.spring.henallux.model;


import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


public class RegisterForm 
{
	@NotEmpty
	@Size(max=45)
	private String firstName;
	@NotEmpty
	@Size(max=45)
	private String lastName;
	@Size(min=0, max=15)
	private String phoneNumber;
	@NotNull
	@Min(1)
	@Max(9999)
	private Integer numberOfStreet;
	@NotEmpty
	@Size(max=90)
	private String street;
	@NotNull
	@Min(1)
	@Max(1000000000)
	private Integer zipCode;
	@NotEmpty
	@Size(max=45)
	private String city;
	@Email
	@NotEmpty
	@Size(max=45)
	private String eMail;
	@NotEmpty
	@Size(min=6, max=25)
	private String password;
	@NotEmpty
	@Size(min=6,max=25)
	private String passwordConfirmation;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	@Past
	private Date birthDate;
	@NotEmpty
	@Size(min=3,max=45)
	private String pseudo;
	@NotEmpty
	@Size(min=2,max=45)
	private String country;
	
	public RegisterForm()
	{
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public Integer getNumberOfStreet() {
		return numberOfStreet;
	}

	public void setNumberOfStreet(Integer numberOfStreet) {
		this.numberOfStreet = numberOfStreet;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
	
}