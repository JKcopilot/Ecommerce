package com.syntellect.Bean;

import jakarta.persistence.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "products")
public class ProductBean {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
    private Long product_id;
	
	@Column(name = "product_name")
    private String product_name;
	
	@Column(name = "product_description")
    private String product_description;
	
	@Column(name = "product_price")
    private double product_price;

	public ProductBean(){
		
	}

	public ProductBean(String product_name, String product_description, double product_price) {
		super();
		this.product_name = product_name;
		this.product_description = product_description;
		this.product_price = product_price;
	}

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_description() {
		return product_description;
	}

	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}

	public double getProduct_price() {
		return product_price;
	}

	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}

}
