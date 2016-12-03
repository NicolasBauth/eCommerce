package com.spring.henallux.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class UserEntity 
{
	@Id
	@Column(name ="idUtilisateur")
	private Integer userId;
	@Column(name ="nom")
	private String lastName;
	@Column(name="prenom")
	private String firstName;
	@Column(name="pseudo")
	private String pseudo;
	@Column(name="telephone")
	private String phoneNumber;
	@Column(name="email")
	private String email;
	@Column(name="motDePasse")
	private String password;
	@Column(name="dateNaissance")
	private java.util.Date birthDate;
	@Column(name="rue")
	private String street;
	@Column(name="numero")
	private Integer numero;
	@Column(name="ville")
	private String town;
	@Column(name="codePostal")
	private Integer zipCode;
	@Column(name="pays")
	private String country;
	public UserEntity()
	{
		
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public java.util.Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(java.util.Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public Integer getZipCode() {
		return zipCode;
	}
	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
}
