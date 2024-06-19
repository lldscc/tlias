package com.llds.service;

import com.llds.pojo.Emp;
import com.llds.pojo.PageBean;
import com.llds.pojo.Result;

import java.time.LocalDate;
import java.util.List;

//员工业务规则
public interface EmpService {
    /**
     *用户登录
     */
    public Emp login(Emp emp);

    /**
     *用户注册
     */
    public Result register(Emp emp);



    /**
     * 条件分页查询
     *
     * @param page     页码
     * @param pageSize 每页展示记录数
     * @param name     姓名
     * @param gender   性别
     * @param begin   开始时间
     * @param end     结束时间
     * @return
     */
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);


    /**
     *删除员工
     */
    void delete(List<Integer> ids);

}
