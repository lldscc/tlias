package com.llds;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//@SpringBootTest
class TliasWebApplicationTests {

    @Test
    void contextLoads() {
    }

    //生成jwt
    @Test
    public void genJwt(){
        Map<String,Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("username","Tom");

        String jwt = Jwts.builder()
                .setClaims(claims) //自定义内容(载荷)
                .signWith(SignatureAlgorithm.HS256, "itheima") //签名算法
                .setExpiration(new Date(System.currentTimeMillis() + 24*3600*1000)) //有效期
                .compact();

        System.out.println(jwt);
    }
    //解析jwt
    @Test
    public void parseJwt(){
        Claims claims = Jwts.parser()
                .setSigningKey("itheima")//指定签名密钥
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwiZXhwIjoxNzAyMTA4MDQ3LCJ1c2VybmFtZSI6IlRvbSJ9.hlT4BfJ0R55GHbG1xw6z1GdK2mFxG08NZTVSlfAA55A")
                .getBody();

        System.out.println(claims);
    }















}
