package org.dinesh.softarica.productService.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {
	
	private long pid;
	private String productName;
	private Date created;
	private String productPrice;
	
	
	public Product() {
		
	}


	public Product(long pid, String productName, String productPrice) {
		this.pid = pid;
		this.productName = productName;
		this.productPrice = productPrice;
		this.created = new Date();
	}


	public long getPid() {
		return pid;
	}


	public void setPid(long pid) {
		this.pid = pid;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public Date getCreated() {
		return created;
	}


	public void setCreated(Date created) {
		this.created = created;
	}


	public String getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	
	
	
	

}
