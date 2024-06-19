package com.llds.mapper;

import com.llds.pojo.Emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

/*数据访问层*/
@Mapper
public interface EmpMapper {
    //给service层调用
    //总记录数
//    @Select("select count(*) from emp")
//    public Long count();
    //获取当前页的结果列表
//    @Select("select * from emp limit #{start}, #{pageSize}")
//    public List<Emp> list(Integer start, Integer pageSize);

    //分页查询员工数据(PageHelper分页插件)
//    @Select("select * from emp")
//    复杂查询xml文件映射
    List<Emp> list();
    List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);


//    登录
    @Select("select id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time " +
            "from emp " +
            "where username=#{username} and password =#{password}")
    public Emp getByUsernameAndPassword(Emp emp);

//    注册
    @Insert("INSERT INTO emp (username, password, create_time, update_time) VALUES (#{username}, #{password}, #{createTime}, #{updateTime})")
    int insertEmp(Emp emp);


}
