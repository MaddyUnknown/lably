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
import com.xfactor.lably.entity.Lab;

@RestController
@RequestMapping("/lab")
public class LabController{

    private Map<String, Lab> labMap = new HashMap<String, Lab>();   // Map to store the name: lab object pair

    @GetMapping("")                                                 // Get request to display all labs in map format
    public Map<String, Lab> allLab()
    {
        return labMap;
    }

    @GetMapping("/first5")                                          // Display 5 labs details in list format
    public List<Lab> unique_lab5()
    {
        List<Lab> LabList = new ArrayList<Lab>();
        int length = 0;
        Iterator<String> i = labMap.keySet().iterator();
        while(i.hasNext() && length<5)
        {
            LabList.add(labMap.get(i.next()));
            length += 1;
        }
        return LabList;
    }


    @GetMapping("/lab")                                             // Accepts name as parameter to get the object
    public Lab unique_lab(@RequestParam String name)
    {
        return labMap.get(name);
    }

    @PostMapping("/addLab")                                         // Post request to add the details of lab
    public String addLab(@RequestBody Lab obj)
    {
        if(labMap.containsKey(obj.getName()))
        {
            return "Lab name already taken";
        }
        else
        {
            labMap.put(obj.getName(), obj);
            return "Lab added";
        }
    }
}