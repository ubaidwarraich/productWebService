package com.uog.product.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uog.product.model.ProductCategory;
import com.uog.product.repository.productCategoryRepository;

@RestController
@CrossOrigin
@RequestMapping("/productcategory")
public class productCategoryController {
	
	private static final Logger log = LoggerFactory.getLogger(productCategoryController.class);
	
	@Autowired
	private productCategoryRepository productcategoryrepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getAll() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		log.info("GET: /productcategory");
		
		String rtn;
		List<ProductCategory> productCategory=productcategoryrepository.findActive();
		rtn=mapper.writeValueAsString(productCategory);
		return rtn;
	}
	
}
