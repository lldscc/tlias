package com.llds.service;

import com.llds.pojo.Dept;

import java.util.List;

//部门业务规则
public interface DeptService {
    /*
    * 查询所有部门的数据
    * */
    List<Dept> list();


//    删除部门数据
    void delete(Integer id);


//新增部门数据
    void add(Dept dept);
}
