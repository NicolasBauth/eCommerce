package com.spring.henallux.model;

public class Image 
{
	private Integer imageId;
	private String path;
	private String name;
	private Product referencedProduct;
	public Image()
	{
		
	}
	public Integer getImageId() {
		return imageId;
	}
	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Product getReferencedProduct() {
		return referencedProduct;
	}
	public void setReferencedProduct(Product referencedProduct) {
		this.referencedProduct = referencedProduct;
	}
	
}
