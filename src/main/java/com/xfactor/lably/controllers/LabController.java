package com.xfactor.lably.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.xfactor.lably.entity.Lab;
import com.xfactor.lably.repository.LabRepository;

@RestController
@RequestMapping("/lab")
public class LabController{

    @Autowired
    private LabRepository labrepo;                       // Automatic DAO implementation

    @GetMapping("")                                     // Display 5 labs details in list format
    public List<Lab> first5()
    {
        List<Lab> out = labrepo.findTop5By();
        return out;
    }


    @GetMapping("/search")                              // Accepts name as parameter to get the object
    public Lab unique_lab(@RequestParam String name)
    {
        Lab  out = labrepo.findByName(name);
        return out;
    }

    @PostMapping("/addLab")                           // Post request to add the details of lab
    public void addLab(@RequestBody Lab obj)
    {
        labrepo.save(obj);
    }
}