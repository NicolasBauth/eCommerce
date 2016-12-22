package com.spring.henallux.dataAccess.entity;


import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="utilisateur")
@NamedQueries({
	@NamedQuery(
			name = "findUserByConnection",
			query = "from UserEntity u where u.pseudo = :pseudo and u.password = :password"
			),
})
public class UserEntity 
{
	@Id
	@Column(name ="idutilisateur")
	private Integer userId;
	@Column(name ="nom")
	private String lastName;
	@Column(name="prenom")
	private String firstName;
	@Column(name="pseudo")
	private String pseudo;
	@Column(name="telephone")
	private Integer phoneNumber;
	@Column(name="email")
	private String email;
	@Column(name="motdepasse")
	private String password;
	@Column(name="datenaissance")
	private java.util.Date birthDate;
	@Column(name="rue")
	private String street;
	@Column(name="numero")
	private Integer numberOfStreet;
	@Column(name="ville")
	private String town;
	@Column(name="codepostal")
	private Integer zipCode;
	@Column(name="pays")
	private String country;
	@OneToMany(mappedBy="customer")
	private Collection<OrderEntity> orders; 
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
	public Integer getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Integer phoneNumber) {
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
	public Integer getNumberOfStreet() {
		return numberOfStreet;
	}
	public void setNumberOfStreet(Integer numberOfStreet) {
		this.numberOfStreet = numberOfStreet;
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
	public Collection<OrderEntity> getOrders() {
		return orders;
	}
	public void setOrders(Collection<OrderEntity> orders) {
		this.orders = orders;
	}
	
	
}
