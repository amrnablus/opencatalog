package com.gmail.amrnablus.opencatalog.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Amr Shahin <amrnablus at gmail dot com>
 *
 */

@Document(collection = "products_attributes")
public class ProductAttribute {

	@Id
	private String id;
	
	private String code;
	
	private String value;

	public ProductAttribute( ) {
		
	}
	
	public ProductAttribute( String code, String value ) {
		this.code = code;
		this.value = value;
	}

	public String getId( ) {
		return this.id;
	}
	
	public void setId( String id ) {
		this.id = id;
	}
	
	public void setCode( String code ) {
		this.code = code;
	}
	
	public String getCode( ) {
		return this.code;
	}
	
	public void setValue( String value ) {
		this.value = value;
	}
	
	public String getValue( ) {
		return this.value;
	}
	
	@Override
	public String toString( ) {
		return "Attribute code: " + code + " has value: " + value;
	}
	
}
