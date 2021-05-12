package com.xfactor.lably.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.xfactor.lably.entity.Customer;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Customer")
public class CustomerController{
    private List<Customer> CustomerList = new ArrayList<Customer>();         // List holding Customer Details

    @PostMapping("/addCustomer")                                            // POST request to Add Customer
    public void add_customer(@RequestBody Customer obj)
    {
        CustomerList.add(obj);
    }

    @GetMapping("")                                                        // GET request for 5 customers
    public List<Customer> first5()
    {
        List<Customer> out  = new ArrayList<Customer>();
        int size = 5;
        if(CustomerList.size()<5)
            size = CustomerList.size();
        for(int i=0; i<size; i++)
        {
            out.add(CustomerList.get(i));
        }
        return out;
    }

    @GetMapping("search")                                                  // GET request for specific name
    public Customer search(@RequestParam String name)
    {
        Customer out = null;
        for(int i=0; i<CustomerList.size(); i++)
        {
            if(CustomerList.get(i).getName().equalsIgnoreCase(name))
            {
                out = CustomerList.get(i);
                break;
            }
        }
        return out;
    }

}
