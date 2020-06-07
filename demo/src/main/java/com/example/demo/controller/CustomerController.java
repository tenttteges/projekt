package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	private CustomerService customerService;
	
	public CustomerController(CustomerService theCustomerService) {
		customerService = theCustomerService;
	}

	@GetMapping(value = "list")
	public String listCustomers(Model theModel) {
		
		List<Customer> theCustomers = customerService.findAll();

		theModel.addAttribute("customers", theCustomers);
		
		return "/list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd (Model theModel) {
		
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId,
									Model theModel) {
		
		Customer theCustomer = customerService.findById(theId);
		
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}

	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
	
		customerService.save(theCustomer);
		
		return "redirect:/customers/list";
	}
	
	@PostMapping("/delete")
	public String delete(@RequestParam("customerId") int theId) {
		
		// delete the employee
		customerService.deleteById(theId);
		
		// redirect to /employees/list
		return "redirect:/customers/list";
		
	}
	
	@GetMapping("/search")
	public String delete(@RequestParam("customerName") String theName,
						 Model theModel) {
		
		// delete the employee
		List<Customer> theCustomers = customerService.searchBy(theName);
		
		// add to the spring model
		theModel.addAttribute("customer", theCustomers);
		
		// send to /employees/list
		return "/list-customer";
		
	}
}









