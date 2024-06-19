package com.llds.mapper;


import com.llds.pojo.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/*数据访问层*/
//交给IOC容器
@Mapper
public interface DeptMapper {
    //给service层调用
    //查询所有部门
    @Select("select * from dept")
    //自动映射，返回值封装到一个集合里
    List<Dept> list();

    //删除数据
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);


    //新增部门数据
    @Insert("insert into dept (name, create_time, update_time) values (#{name},#{createTime},#{updateTime})")
    void inser(Dept dept);
}
