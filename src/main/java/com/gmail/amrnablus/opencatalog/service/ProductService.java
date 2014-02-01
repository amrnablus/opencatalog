package com.gmail.amrnablus.opencatalog.service;


//import static org.springframework.data.mongodb.core.query.Criteria.where;
//import static org.springframework.data.mongodb.core.query.Query.query;
//import static org.springframework.data.mongodb.core.query.Update.update;

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
     
    public void deletePerson( Product product ) {
    	mongoOperations.remove(product);
    }
     
    public void updatePerson( Product product ) {
    	mongoOperations.insert(product);      
    }

}