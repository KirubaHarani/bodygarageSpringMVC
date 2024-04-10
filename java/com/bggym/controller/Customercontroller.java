package com.bggym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.bggym.service.Customerservice;
import com.bggym.model.Customer;

@Controller
@RequestMapping
public class Customercontroller
{

	@Autowired
	Customerservice customerservice;
	
	@GetMapping("Customerentryform")
	public String addCust()
	{
		return "Customerentryform";
	}
	
	@PostMapping("/insertCustomer")
	public String insertCustomer(@ModelAttribute("insertCustomer")Customer cust) {
	  
		System.out.println("Received Customer:");
        System.out.println("Name: " + cust.getCustname());
        System.out.println("Gender: " + cust.getGender());
        System.out.println("Date of Birth: " + cust.getDob());
       
        // Print other fields as needed

        customerservice.addCust(cust);

        System.out.println("Customer saved successfully:");
        System.out.println("Name: " + cust.getCustname());
        System.out.println("Gender: " + cust.getGender());
        System.out.println("Date of Birth: " + cust.getDob());
       
       String registeredBy=cust.getRegisteredby();
        
   //     return "custdetailsform";
       return "redirect:/custdetailsform?registeredby=" + registeredBy;
    }
	
	@GetMapping("custdetailsform")
	public String loadCustomer(Model m)
	{
		m.addAttribute("Customer", customerservice.getAllCustomer());
		m.addAttribute("title", "Customer Details");
			return "custdetailsform";
		
	}
	
	//lode edit form
	 
	@GetMapping("/editCustomer/{id}")
		public String lodeEditForm(@PathVariable(value="id") int id, Model m)
		{
		//System.out.println("Controller"+ id);
  		
			Customer cust=customerservice.getByCustId(id);
			
			System.out.println(cust);
			m.addAttribute("Customer", cust);
			m.addAttribute("title", "Edit Customer");
			
			return "custeditform";
			
		}
		
	@GetMapping("/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable("id") int id)
	{
		
		System.out.println("Controller delete:"+ id);
		customerservice.deleteCustomer(id);
		
		
		return "redirect:/custdetailsform";
	}
		
		
		@PostMapping("/editCustomer/updateCustomer")
		public String updateEmp(@ModelAttribute("updateCustomer")Customer cust)
		{
			//System.out.println("Controller:"+cust);
			customerservice.updateCustomer(cust);
			
			return "redirect:/custdetailsform";
			
		}
		

}
