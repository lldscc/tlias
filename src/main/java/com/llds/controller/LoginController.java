package com.llds.controller;


import com.llds.pojo.Emp;
import com.llds.pojo.Result;
import com.llds.service.EmpService;
import com.llds.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@CrossOrigin
public class LoginController {
    //登录接口
    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        log.info("用户名:{}",emp.getUsername());
        Emp e = empService.login(emp); // 返回值为员工信息
        //登录成功,生成jwt令牌，下发给客户端
        if(e !=null ){
            //自定义信息
            Map<String , Object> claims = new HashMap<>();
            claims.put("id", e.getId());
            claims.put("username",e.getUsername());
            claims.put("name",e.getName());

            //使用JWT工具类，生成身份令牌
            String token = JwtUtils.generateJwt(claims);
            return Result.success(token);
        }
        //登录失败，返回错误信息
        return Result.error("用户名或密码错误");

    }
}
