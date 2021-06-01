package com.cqu.dao;

import com.cqu.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TeacherMapper {

    @Select("select * from Teacher where id=#{tid}")
    Teacher getTeacher(@Param("tid") int id);
}
