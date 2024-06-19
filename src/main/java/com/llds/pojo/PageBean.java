package com.llds.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {
//    员工分页查询所需的数据
    private Long total;  //总记录数
    private List rows; //当前页的数据列表
}
