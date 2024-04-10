package com.bggym.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bggym.dao.Customerdao;
import com.bggym.model.Customer;


@Service
public class Customerservice {
    
    @Autowired
    Customerdao customerdao;

    public void addCust(Customer cust) {
        System.out.println("Received customer: " + cust);
        customerdao.addCustomer(cust);
    }
    
    public List<Customer> getAllCustomer()
    {
    	return customerdao.getAllCustomer();
    }
    
  //get emp by id
	
    public Customer getByCustId(int id) {
        System.out.println("Service: " + id);
        return customerdao.getByCustNo(id);
    }
    
    public void updateCustomer(Customer cust)
	{
    	//System.out.println("Service:"+ cust);
    	customerdao.updateCust(cust);
	}
    
    public void deleteCustomer(int custno)
	{
    	System.out.println("Service Delete custno:"+custno);
    	customerdao.deleteCust(custno);
	}
}