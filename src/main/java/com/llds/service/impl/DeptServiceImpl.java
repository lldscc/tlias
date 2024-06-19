package com.llds.service.impl;

import com.llds.mapper.DeptMapper;
import com.llds.pojo.Dept;
import com.llds.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


//部门业务实现类
@Slf4j
@Service
public class DeptServiceImpl implements DeptService {
    //调用mapper层，实现对数据库的操作
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Dept> list() {
    //调用mapper层查询所有部门
        return deptMapper.list();
    }

    @Override
    public void delete(Integer id){
        //调用mapper层删除数据
        deptMapper.deleteById(id);
    }

    @Override
    public void add(Dept dept){
        //调用mapper层新增数据
        //补全部门数据
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        // 调用mapper层新增数据
        deptMapper.inser(dept);

    }
}
