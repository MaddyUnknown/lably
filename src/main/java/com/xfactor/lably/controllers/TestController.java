package com.xfactor.lably.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import com.xfactor.lably.entity.Test;
import com.xfactor.lably.repository.TestRepository;

@RestController
@RequestMapping("/test")
public class TestController{

    @Autowired
    private TestRepository testrepo;                        // Automatic DAO implementation

    @PostMapping("/addTest")                                // POST request to add Test obj
    public void add_test(@RequestBody Test obj)
    {
        testrepo.save(obj);
    }
    
    @GetMapping("")                                         // GET request to get 5 test obj
    public List<Test> first5()
    {
        List<Test> out = testrepo.findTop5By();
        return out;
    }

    @GetMapping("search")                                  // GET request to for a given name
    public Test search(@RequestParam String name)
    {
        Test out = testrepo.findByName(name);
        return out;
    }

}
