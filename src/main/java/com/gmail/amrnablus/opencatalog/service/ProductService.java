package com.gmail.amrnablus.opencatalog.service;

import java.util.List;
import com.gmail.amrnablus.opencatalog.model.Product;
import com.gmail.amrnablus.opencatalog.model.ProductAttribute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

/**
 * @author Amr Shahin <amrnablus at gmail dot com>
 *
 */

@Repository
public class ProductService {

	Logger logger = LoggerFactory.getLogger(ProductService.class);

	@Autowired
	MongoOperations mongoOperations;
	
	public void addProduct( Product product ) {
		if (!mongoOperations.collectionExists(Product.class)) {
			mongoOperations.createCollection(Product.class);
		}
		mongoOperations.insert(product);
	}

	public List<Product> listProducts() {
		return mongoOperations.findAll(Product.class);
	}

	public void deleteProduct( Product product ) {
		mongoOperations.remove(product);
	}

	public void updateProduct( Product product ) {
		mongoOperations.insert(product);      
	}
}
