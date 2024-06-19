package com.llds.controller;


import com.llds.pojo.Emp;
import com.llds.pojo.Result;
import com.llds.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@CrossOrigin
public class RegController {

    @Autowired
    private EmpService empService;

    @PostMapping("/reg")
    public Result reg(@RequestBody Emp emp){
        return empService.register(emp);
    }



}
