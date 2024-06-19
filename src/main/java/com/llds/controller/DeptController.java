package com.llds.controller;

import com.llds.pojo.Dept;
import com.llds.pojo.Result;
import com.llds.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//部门管理控制器
@Slf4j
@RestController
@RequestMapping("/depts")   //RequestMapping注解抽取depts
@CrossOrigin(origins = "*", maxAge = 3600)
//@CrossOrigin
public class DeptController {

    //注入部门业务对象(service层)
    @Autowired
    private DeptService deptService;


    //请求接口
    //查询所有部门
    @GetMapping
    public Result list(){
        log.info("查询所有部门");  //日志信息
        //调用service层查询所有部门
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    //删除部门接口
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("删除部门成功");
        deptService.delete(id);
        return Result.success();
    }


    //新增部门接口
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("新增部门成功");
        //service层
        deptService.add(dept);
        return Result.success();

    }



}
