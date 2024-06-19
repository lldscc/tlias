package com.llds.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.llds.mapper.EmpMapper;
import com.llds.pojo.Emp;
import com.llds.pojo.PageBean;
import com.llds.pojo.Result;
import com.llds.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

//员工业务实现类
@Slf4j
@Service  //依赖注入和管理
public class EmpServiceImpl implements EmpService {
    //调用mapper层
    @Autowired
    private EmpMapper empMapper;

    //登录的实现
    @Override
    public Emp login(Emp emp) {
        //调用Mapper层
        return empMapper.getByUsernameAndPassword(emp);
    }

    // 注册的实现
    @Override
    public Result  register(Emp emp) {
        // 检查用户名是否已存在
        if (empMapper.findByUsername(emp.getUsername()) != null) {
            return Result.failure("用户名已存在");
        }

        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        int result = empMapper.insertEmp(emp);
        if (result > 0) {
            return Result.success(emp);
        } else {
            return Result.failure("注册失败");
        }
    }


    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end){
        //PageHelper分页插件进行分页
        // 设置分页参数
        PageHelper.startPage(page,pageSize);
        //执行条件分页查询
        List<Emp> empList = empMapper.list(name, gender, begin, end);
        Page<Emp> p = (Page<Emp>) empList;
        //封装PageBean
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }


    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }



}
