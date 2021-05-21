package com.xfactor.lably.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.xfactor.lably.entity.Customer;
import com.xfactor.lably.repository.CustomerRepository;
import java.util.List;

@RestController
@RequestMapping("/Customer")
public class CustomerController{
    
    @Autowired
    private CustomerRepository customerrepo;                                  // Automatic DAO implementation

    @PostMapping("/addCustomer")                                            // POST request to Add Customer
    public void add_customer(@RequestBody Customer obj)
    {
        customerrepo.save(obj);
    }

    @GetMapping("")                                                        // GET request for 5 customers
    public List<Customer> first5()
    {
        List<Customer> out  = customerrepo.findTop5By();
        return out;
    }

    @GetMapping("search")                                                  // GET request for specific name
    public Customer search(@RequestParam String name)
    {
        Customer out = customerrepo.findByName(name);
        return out;
    }

}
