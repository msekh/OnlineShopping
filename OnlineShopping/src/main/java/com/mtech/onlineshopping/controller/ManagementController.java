package com.mtech.onlineshopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mtech.onlineshopping.util.FileUploadUtility;
import com.mtech.onlineshopping.validator.ProductValidator;
import com.mtech.shoppingBackEnd.dao.CategoryDAO;
import com.mtech.shoppingBackEnd.dao.ProductDAO;
import com.mtech.shoppingBackEnd.dto.Category;
import com.mtech.shoppingBackEnd.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {

	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ProductDAO productDAO;
	
	private static final Logger logger=LoggerFactory.getLogger(ManagementController.class);

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name="operation",required=false) String operation) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");

		Product nProduct = new Product();
		// set few new Product
		nProduct.setSupplierId(13);
		nProduct.setActive(true);

		mv.addObject("product", nProduct);
		if(operation != null) {
			if(operation.equals("product")) {
				mv.addObject("message", "Product submited successfully.");
			}
		}
		return mv;
	}
	//handling product Submission
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String handlerProductsSubmission( @Valid @ModelAttribute("product") Product mProduct 
			,BindingResult results, Model model, HttpServletRequest request) {
		
		new ProductValidator().validate(mProduct, results);
		
		//Check if there are any errors
		if(results.hasErrors()) {
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "Manage Products.");
			model.addAttribute("message", "Validation failed for product submission!");
			
			return "page";			
		}
		
		logger.info(mProduct.toString());
		//create a new product record
		productDAO.add(mProduct);
		
		if(!mProduct.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile( request, mProduct.getFile(), mProduct.getCode());
		}
		
		return "redirect:/manage/products?operation=product";
	}
	
	@RequestMapping(value="/product/{id}/activation", method=RequestMethod.POST)
	@ResponseBody
	public String handleProductActvation(@PathVariable int id) {
		//is going to fetch the product from the database
		Product product=productDAO.get(id);
		boolean isActive=product.isActive();
		//Actvating and deactivating based on the value
		product.setActive(!product.isActive());
		//udating the product
		productDAO.update(product);
		return (isActive)?""
				+ "You have successfully deactivated the product with id "+product.getId()
		:"You have successfully activated the product with id "+product.getId() ;
		
	}
	// returning categories for the all request mapping
	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return categoryDAO.list();
	}
}
