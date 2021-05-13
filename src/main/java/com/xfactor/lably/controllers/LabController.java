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
import com.xfactor.lably.entity.Lab;

@RestController
@RequestMapping("/lab")
public class LabController{

    private List<Lab> LabList = new ArrayList<Lab>();   // List to store the lab information

    @GetMapping("")                                     // Display 5 labs details in list format
    public List<Lab> first5()
    {
        List<Lab> out = new ArrayList<Lab>();
        int size = 5;
        if(LabList.size()<5)
            size = LabList.size();

        for(int i=0; i<size; i++)
            out.add(LabList.get(i));
        
        return out;
    }


    @GetMapping("/search")                              // Accepts name as parameter to get the object
    public Lab unique_lab(@RequestParam String name)
    {
        Lab  out = null;
        for(int i=0; i<LabList.size(); i++)
        {
            if(LabList.get(i).getName().equalsIgnoreCase(name))
            {
                out = LabList.get(i);
                break;
            }
        }
        return out;
    }

    @PostMapping("/addLab")                           // Post request to add the details of lab
    public void addLab(@RequestBody Lab obj)
    {
        LabList.add(obj);
    }
}