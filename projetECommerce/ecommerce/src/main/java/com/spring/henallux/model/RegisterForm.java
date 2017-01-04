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
	@NotEmpty(message="Every wizard has a first name.")
	@Size(max=45, message="Your wizard first name is too long for anyone to understand it.")
	private String firstName;
	@NotEmpty(message="Last name is mandatory.")
	@Size(max=45, message="Your last name is too long.")
	private String lastName;
	@Size(min=0, max=15, message="Must be a valid phone number.")
	private String phoneNumber;
	@NotNull(message="Incorrect number:it must be between 1 and 9999")
	@Min(1)
	@Max(9999)
	private Integer numberOfStreet;
	@NotEmpty(message="No wizard can order out of nowhere. We need to know what's the street you live in.")
	@Size(max=90, message="Your street name is too long for us mortals to remember.")
	private String street;
	@NotNull(message="Your zip code is required.")
	@Min(0)
	@Max(1000000000)
	private Integer zipCode;
	@NotEmpty(message="We only deliver our products to legit wizards. Please tell us where you live so that we can be sure you aren't an exiled dangerous wizard.")
	@Size(max=45, message="Your city name is way too long. Please use a magic spell to shorten it.")
	private String city;
	@Email(message="Your wizard e-mail has to be a valid e-mail.")
	@NotEmpty(message="Your wizard e-mail is required for us to contact you.")
	@Size(max=45, message="Your wizard e-mail is too long.")
	private String eMail;
	@NotEmpty(message="Please have a password. Even the most powerful wizards need identity protection when it comes to the internet.")
	@Size(min=6, max=25, message="Your password cannot contain less than 6 characters, and not more than 25")
	private String password;
	@NotEmpty(message="For your own good, don't forget to confirm your password")
	@Size(min=6,max=25 ,message="Your password cannot contain less than 6 characters, and not more than 25")
	private String passwordConfirmation;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message="Every Wizard was born one day. We need to know what day it is.")
	@Past(message="You can't be born in the future, you are a wizard, not a time traveller.")
	private Date birthDate;
	@NotEmpty(message="Your username is required.")
	@Size(min=3,max=45, message="Your username must contain more than 3 characters, but less than 45")
	private String pseudo;
	@NotEmpty(message="We do respect every magic cultures in the world. Don't be scared to tell us your country.")
	@Size(min=2,max=45, message="Your country name cannot contain less than 2 characters or more than 45")
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