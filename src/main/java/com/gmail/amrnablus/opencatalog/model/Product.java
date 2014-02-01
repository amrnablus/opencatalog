package com.gmail.amrnablus.opencatalog.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.geo.Point;
//import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.gmail.amrnablus.opencatalog.model.ProductAttribute;

/**
 * @author Amr Shahin <amrnablus at gmail dot com>
 *
 */

@Document(collection = "products")
public class Product {
	
	public enum ProductType {
		SIMPLE
	}
	
	@Id
	private String id;
	
	private String sku;
	
	private ProductType type;
	
	private long creationDate;
	
	private long updateDate;
	
	private List<ProductAttribute> attributes = new ArrayList<ProductAttribute>();

	public Product( ) {
		
	}
	
	public Product( String sku ) {
		this.sku = sku;
		this.creationDate = this.updateDate = System.currentTimeMillis()/1000;
	}
	
	public String getId( ) {
		return this.id;
	}
	
	public void setId( String id ) {
		this.id = id;
	}
	
	public String getSku( ) {
		return this.sku;
	}
	
	public void setSku( String sku ) {
		this.sku = sku;
	}
	
	public List<ProductAttribute> getAttributes( ) {
		return this.attributes;
	}
	
	public void addAttribute( ProductAttribute attr ) {
		this.attributes.add(attr);
	}
	
	public void setAttributes( List<ProductAttribute> attributes ) {
		this.attributes = attributes;
	}
	
	public ProductType getType( ) {
		return this.type;
	}
	
	public void setType( ProductType type ) {
		this.type = type;
	}
	
	@Override
	public String toString( ) {
		return "Product sku: " + sku + " has attributes: " + attributes;
	}
}
