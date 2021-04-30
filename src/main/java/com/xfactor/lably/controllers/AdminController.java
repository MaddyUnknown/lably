package com.xfactor.lably.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import com.xfactor.lably.entity.Admin;

@RestController
@RequestMapping("/admin")
public class AdminController{

    private Map<String, Admin> AdminMap = new HashMap<String, Admin>();       // Map to store the details in username: object pair

    @GetMapping("")                                                           // Get request to get all the admin users
    public Map<String, Admin> AllUser()
    {
        return AdminMap;
    }

    @GetMapping("/first5")                                                    // Return 5 admin details in list format
    public List<Admin> User5()
    {
        List<Admin> adminList = new ArrayList<Admin>();
        
        int length = 0;
        Iterator<String> i = AdminMap.keySet().iterator();
        while(i.hasNext() && length<5)
        {
            adminList.add(AdminMap.get(i.next()));
            length += 1;
        }
        return adminList;
        
    }

    @GetMapping("/user")                                                      // return admin details based to username parameter
    public Admin User(@RequestParam String username)
    {
        return AdminMap.get(username);
    }

    @PostMapping("/addAdmin")                                                 // Post request to add admin details
    public String addName(@RequestBody Admin obj)
    {
        if(AdminMap.containsKey(obj.getUsername()))
        {
            return "Error!! Username already taken!!";
        }
        else
        {
            AdminMap.put(obj.getUsername(), obj);
            return "New Admin Added";
        }
    }
}