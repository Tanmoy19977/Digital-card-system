package com.example.poc.springPoc.controller;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.poc.springPoc.Entity.card;
import com.example.poc.springPoc.Entity.customer;
import com.example.poc.springPoc.Entity.user;
import com.example.poc.springPoc.repository.cardRepository;
import com.example.poc.springPoc.repository.customerRepository;
import com.example.poc.springPoc.repository.userRepository;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class PocController {
	
	@Autowired
	customerRepository cRepository;
	
	@Autowired
	cardRepository cRepository2;
	
	@Autowired
	userRepository uRepository;
	
	@GetMapping("/")
	public String goToHome()
	{
		return "home";
	}
	
	@ResponseBody
	@GetMapping("/allcust")
	public List<customer> getAllCust()
	{
		return cRepository.findAll();
	}
	
	
	@PostMapping("/savecust")
	public String saveCust(HttpServletRequest req, Model model)
	{
		List<card> cdsCards = null;
		int id = 4;//Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String sex = req.getParameter("sex");
		String address = req.getParameter("address");
		String category = req.getParameter("category");
		String surgery = req.getParameter("surgery");
		String drName = req.getParameter("drname");
		String visitType = req.getParameter("visit");
		customer cus = new customer(id, name, age, sex, address, category, surgery, drName, visitType, cdsCards);
		cRepository.save(cus);
		model.addAttribute("message", "New Customer has been Successfully saved");
		String names = "";
		String ids = "";
		List<customer> cust = cRepository.findAll();
		Iterator iterator = cust.iterator();
	      while(iterator.hasNext()) {
	         customer tempCust = (customer) iterator.next();
	         ids += tempCust.getId()+"_";
	         names += tempCust.getName()+"_";
	      }
	      System.out.println("names = "+names);
	      model.addAttribute("names",names);
	      model.addAttribute("ids",ids);
		card card = new card(); // create a new Card object
	    model.addAttribute("card", card);
		return "main";
	}
	
	@PostMapping("/savecard")
	public String saveCard(@ModelAttribute("card") card cd1,Model model)
	{
		
		cRepository2.save(cd1);
		//System.out.println("This is id ="+cd1.getCardId());
		model.addAttribute("message", "New Card has been created");
		String names = "";
		String ids = "";
		List<customer> cust = cRepository.findAll();
		Iterator iterator = cust.iterator();
	      while(iterator.hasNext()) {
	         customer tempCust = (customer) iterator.next();
	         ids += tempCust.getId()+"_";
	         names += tempCust.getName()+"_";
	      }
	      System.out.println("names = "+names);
	      model.addAttribute("names",names);
	      model.addAttribute("ids",ids);
		card card = new card(); // create a new Card object
	    model.addAttribute("card", card);
		return "main";
	}
	
	@ResponseBody
	@GetMapping("/getcustbyid")
	public Optional<customer> getCustById( HttpServletRequest req)
	{
		//customer cus = new customer(1, "Sankar Molla", "48", "M", "howrah", "fitness & Swimming", "No", "Dr. Shamyal Gupta", "clinic visit");
		int id = Integer.parseInt(req.getParameter("id"));
		return cRepository.findById(id);
		
	}
	
	
	@PostMapping("/login")
	public String login(HttpServletRequest req, Model model, ModelAndView mv)
	{
		String pwd = req.getParameter("password");
		//System.out.println("password from frontend = "+pwd);
		user us = uRepository.findById(1).get();
		String pwdUser = us.getUserPassword();
		if(pwd.equals(pwdUser))
		{
			String names = "";
			String ids = "";
			List<customer> cust = cRepository.findAll();
			Iterator iterator = cust.iterator();
		      while(iterator.hasNext()) {
		         customer tempCust = (customer) iterator.next();
		         ids += tempCust.getId()+"_";
		         names += tempCust.getName()+"_";
		      }
		      System.out.println("names = "+names);
		      model.addAttribute("names",names);
		      model.addAttribute("ids",ids);
		      
		      card card = new card(); // create a new Card object
		      model.addAttribute("card", card);
		      
		      //mv.addObject("user", new user());
		      //model.addAttribute("mid",cRepository.);
			return "main";
		}
		else {
			model.addAttribute("massage","Wrong Password");
			return "home";
		}
	}
	
	@ResponseBody
	@GetMapping("/fetchCust")
	public customer fetchCust(HttpServletRequest req, Model model, ModelAndView mv)
	{
	      int idInt = Integer.parseInt(req.getParameter("ids"));
	      customer cs = cRepository.findById(idInt).get();
	      return cs;
	}
	
	

}
