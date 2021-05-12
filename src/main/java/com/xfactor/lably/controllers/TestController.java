package com.xfactor.lably.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.ArrayList;
import java.util.List;
import com.xfactor.lably.entity.Test;

@RestController
@RequestMapping("/test")
public class TestController{

    private List<Test> TestList = new ArrayList<Test>();

    @PostMapping("/addTest")
    public void add_test(@RequestBody Test obj)
    {
        TestList.add(obj);
    }
    
    @GetMapping("")
    public List<Test> first5()
    {
        List<Test> out = new ArrayList<Test>();
        int size = 5;
        if(TestList.size()<5)
            size = TestList.size();
        for(int i =0; i<size; i++)
        {
            out.add(TestList.get(i));
        }
        return out;
    }

    @GetMapping("search")
    public Test search(@RequestParam String name)
    {
        Test out = null;
        for(int i=0; i<TestList.size(); i++)
        {
            if(TestList.get(i).getName().equalsIgnoreCase(name))
            {
                out = TestList.get(i);
                break;
            }
        }
        return out;
    }

}
