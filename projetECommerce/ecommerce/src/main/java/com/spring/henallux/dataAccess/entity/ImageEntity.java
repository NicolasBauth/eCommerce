package com.spring.henallux.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="image")
public class ImageEntity 
{
	@Id
	@Column(name="idImage")
	private Integer imageId;
	@Column(name="nom")
	private String name;
	@Column(name="chemin")
	private String path;
	@ManyToOne
	@JoinColumn(name="id_produit",referencedColumnName="idProduit")
	private ProductEntity referencedProduct;
	
	public ImageEntity()
	{
		
	}
	public Integer getImageId() {
		return imageId;
	}
	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public ProductEntity getReferencedProduct() {
		return referencedProduct;
	}
	public void setReferencedProduct(ProductEntity referencedProduct) {
		this.referencedProduct = referencedProduct;
	}
	
	
}
