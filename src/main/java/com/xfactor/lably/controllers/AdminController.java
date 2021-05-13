package com.xfactor.lably.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.ArrayList;
import com.xfactor.lably.entity.Admin;

@RestController
@RequestMapping("/admin")
public class AdminController{

    private List<Admin> AdminList = new ArrayList<Admin>();       // List to store the details in admin


    @GetMapping("")                                              // Return 5 admin details
    public List<Admin> first5()
    {
        List<Admin> out = new ArrayList<Admin>();
        
        int size = 5;
        if(5>AdminList.size())
            size = AdminList.size();
        for(int i=0; i<size; i++)
            out.add(AdminList.get(i));
        return out;
        
    }

    @GetMapping("/search")                                      // return admin details based to username parameter
    public Admin User(@RequestParam String username)
    {
        Admin out= null;
        for(int i=0; i<AdminList.size(); i++)
        {
            if(AdminList.get(i).getUsername().equalsIgnoreCase(username))
            {
                out = AdminList.get(i);
                break;
            }
        }
        return out;
    }

    @PostMapping("/addAdmin")                                                 // Post request to add admin details
    public void addName(@RequestBody Admin obj)
    {
        AdminList.add(obj);
    }
}