package com.llds.controller;

import com.llds.pojo.PageBean;
import com.llds.pojo.Result;
import com.llds.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

//员工管理控制器
@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/emps")
public class EmpController {
    //注入service层
    @Autowired
    private EmpService empService;

    //查询员工
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        //记录日志
        log.info("分页查询，参数：{},{},{},{},{},{}", page, pageSize,name, gender, begin, end);
        //调用业务层分页查询功能
        PageBean pageBean = empService.page(page, pageSize, name, gender, begin, end);
        //响应
        return Result.success(pageBean);
    }



    //删除员工
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable List<Integer> id){
        empService.delete(id);
        return Result.success();
    }

}










