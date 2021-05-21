package com.xfactor.lably.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.xfactor.lably.entity.Admin;
import com.xfactor.lably.repository.AdminRepository;

@RestController
@RequestMapping("/admin")
public class AdminController{

    @Autowired
    AdminRepository adminrepo;                                    // Automatic DAO implementation

    @GetMapping("")                                              // Return 5 admin details
    public List<Admin> first5()
    {
        List<Admin> out = adminrepo.findTop5By();
        return out;
        
    }

    @GetMapping("/search")                                      // return admin details based to username parameter
    public Admin User(@RequestParam String username)
    {
        Admin out= adminrepo.findByUsername(username);
        return out;
    }

    @PostMapping("/addAdmin")                                                 // Post request to add admin details
    public void addName(@RequestBody Admin obj)
    {
        adminrepo.save(obj);
    }
}