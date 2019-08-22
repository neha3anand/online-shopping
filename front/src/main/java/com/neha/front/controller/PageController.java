package com.neha.front.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.neha.back.dao.CategoryDAO;
import com.neha.back.dao.ProductDAO;
import com.neha.back.dao.UserDAO;
import com.neha.back.dto.Address;
import com.neha.back.dto.Category;
import com.neha.back.dto.Product;
import com.neha.back.dto.User;
//import com.neha.front.exception.ProductNotFoundException;

@Controller
public class PageController {
	private static final Logger Logger = LoggerFactory.getLogger(PageController.class);
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private UserDAO userDAO;
	
	
	
	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		Logger.info("Inside PageController index method - INFO");
		Logger.debug("Inside PageController index method - DEBUG");
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickHome", true);
		return mv;
	}

	@RequestMapping(value = { "/about" })
	public ModelAndView about() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}

	@RequestMapping(value = { "/contact" })
	public ModelAndView contact() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}

	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickAllProducts", true);
		return mv;
	}

	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {

		ModelAndView mv = new ModelAndView("page");
		Category category = null;

		category = categoryDAO.get(id);
		mv.addObject("title", category.getName());
		mv.addObject("categories", categoryDAO.list());

		mv.addObject("category", category);
		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}

	/*
	 * @RequestMapping(value = "/show/{id}/product") public ModelAndView
	 * showSingleProduct(@PathVariable int id) throws ProductNotFoundException {
	 * 
	 * ModelAndView mv = new ModelAndView("page"); Product product =
	 * productDAO.get(id); if (product == null) throw new
	 * ProductNotFoundException(); product.setViews(product.getViews() + 1);
	 * productDAO.update(product);
	 * 
	 * mv.addObject("title", product.getName()); mv.addObject("product", product);
	 * 
	 * mv.addObject("userClickShowProduct", true); return mv; }
	 */	
	
	
	@RequestMapping("/register")
	public String register(@RequestParam(value = "error", required = false) String errCode, Model model) {
		if (errCode != null) {
			switch (errCode) {
			case "1":
				model.addAttribute("msg", "User Email Already Present");
				break;
			case "2":
				model.addAttribute("msg", "Password and Confirm Password do not match !");
				break;
			}
		}

		model.addAttribute("userClickRegister", true);
		// model.addAttribute("categories", categoryDAO.list());
		model.addAttribute("user", new User());// hibernate by product dao

		return "page";
	}

	// @RequestMapping(value="/register",method = RequestMethod.POST)
	@PostMapping("/register")
	public String saveUser(@ModelAttribute("user") User user, Model model) {

		
		
		if (userDAO.getByEmail(user.getEmail()) != null) {
			return "redirect:/register?error=1";
		}

		if (!user.getPassword().equals(user.getConfirmPassword())) {
			return "redirect:/register?error=2";
		}
		user.setRole("USER");
		userDAO.add(user);

		model.addAttribute("userClickedSaveUser", true);
		// model.addAttribute("categories", categoryDAO.list());
		Address address = new Address();

		address.setUserId(user.getId());

		model.addAttribute("address", address);// hibernate by product dao

		return "page";
	}

	@PostMapping("/address")
	public String saveUser(@ModelAttribute("address") Address address, Model model) {

		address.setBilling(true);
		userDAO.addAddress(address);

		return "redirect:/login";
	}

}
