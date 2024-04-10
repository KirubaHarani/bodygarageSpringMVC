package com.bggym.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bggym.model.Customer;

@Component
public class Customerdao {

    @Autowired
    HibernateTemplate hibernateTemplate;

    @Transactional
    public void addCustomer(Customer cust) {
        try {
            hibernateTemplate.setCheckWriteOperations(false); // Disables write operation check
           // System.out.println("Received Customer with custno: " + cust.getCustno()); // Print custno
            hibernateTemplate.save(cust);
            System.out.println("Customer saved successfully: " + cust); // Log success
        } catch (Exception e) {
            System.err.println("Error saving customer: " + e.getMessage()); // Log error
            e.printStackTrace();
        }
    }
    
    public List<Customer> getAllCustomer()
    {
    	return hibernateTemplate.loadAll(Customer.class);
    }
    
  //get employee by id
  	@Transactional
  	public Customer getByCustNo(int id)
  	{
  		System.out.println("Dao:"+ id);
  		
  		//String queryString = "SELECT * FROM custdetails WHERE custno = " + custno;
  	    //System.out.println("Executing Query: " + queryString);

  		
  		Customer cust= hibernateTemplate.get(Customer.class, id);
  		//int tablecustno = cust.getCustno();
  		//System.out.println("custno from table:"+ tablecustno);
  		System.out.println(cust);
  		return cust;
  	}
  	
  	@Transactional
    public void updateCust(Customer cust) {
        try {
            System.out.println("Updating Customer: " + cust);
            hibernateTemplate.update(cust);
            System.out.println("Customer updated successfully: " + cust);
        } catch (Exception e) {
            System.err.println("Error updating customer: " + e.getMessage());
            e.printStackTrace();
            // Consider throwing a custom exception or rethrowing the caught exception here
        }
    }

  //delete employee
  	@Transactional
  	public void deleteCust(int custno)
  	{
  		 try {
  			 	hibernateTemplate.setCheckWriteOperations(false); 
  			 	System.out.println("DAO delete custno:"+ custno);  		
  			 	hibernateTemplate.delete(hibernateTemplate.load(Customer.class, custno));
  		 	}
  		 	catch (Exception e)
  		 	{
             System.err.println("Error updated customer: " + e.getMessage()); // Log error
             e.printStackTrace();
  		 	}
  	}
  	
}
