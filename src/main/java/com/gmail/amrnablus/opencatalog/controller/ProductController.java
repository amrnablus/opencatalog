package com.gmail.amrnablus.opencatalog.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gmail.amrnablus.opencatalog.model.Product;
import com.gmail.amrnablus.opencatalog.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = {"/product/list","/product","/"}, method = RequestMethod.GET)
	public @ResponseBody List<Product> getProductsList(ModelMap model) {
		return productService.listProducts();
	}

	@RequestMapping(value = "/product/save", method = RequestMethod.POST)
	public @ResponseBody Product createProduct(@ModelAttribute Product product, ModelMap model) {
		this.productService.addProduct(product);
		return product;
	}

	@RequestMapping(value = "/product/delete", method = RequestMethod.GET)
	public @ResponseBody boolean deleteProduct(@ModelAttribute Product product, ModelMap model) {
		productService.deleteProduct(product);
		return true;
	}

	@RequestMapping(value = "/product/update", method = RequestMethod.POST)
	public @ResponseBody boolean updateProduct(@ModelAttribute Product product, ModelMap model) {
		productService.updateProduct(product);
		return true;
	}
}