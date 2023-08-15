package com.hebust.jtc.DAO;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import com.hebust.jtc.pojo.Student;

import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Auther: 小天
 * @Date: 2023/4/25 - 04 - 25 - 23:23
 * @Decsription: com.hebust.jtc.DAO
 * @version: 1.0
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {
    //    学生登录
    @Select("select count(*) from student where stuId = #{stuId} and stuPwd = #{stuPwd} ")
    public int studentLogin(Student student);

    //    查看所有学生
    @Select("select * from student")
    IPage<Student> getAllStudent(IPage page);

    //    查询学生信息
    @Select("select * from student where ${key} = '${value}'")
    public List<Student> getStudentByAny(String key, String value);

    //    添加学生
    @Insert("insert into student values (#{stuId},#{stuName},#{stuGender},#{managerId},#{stuPwd},#{account},#{deptId})")
    public int addStudent(Student student);

    //    修改密码
    @Update("update student set stuPwd = #{stuPwd} where stuId = #{stuId}")
    public int updatePassword(Student student);

    //    修改管理员信息
    @Update("update student set managerId = #{managerId} where stuId = #{stuId}")
    public int updateManagerId(Student student);

    //    修改宿舍信息
    @Update("update student set deptId = #{deptId} where stuId = #{stuId}")
    public int updateDeptId(Student student);

    //    修改账户信息
    @Update("update student set deptId = #{deptId} where stuId = #{stuId}")
    public int updateAccount(Student student);

    @Update("update student set managerId = #{managerId},deptId = #{deptId} where stuId = #{stuId}")
    public int manageStudent(String stuId,String managerId,String deptId);

    @Delete("delete from student where stuId = #{stuId}")
    public int deleteStudent(String stuId);

    @Update("update student set stuName = #{stuName},stuGender =#{stuGender},stuPwd=#{stuPwd},deptId=#{deptId},managerId=#{managerId},account = #{account}where stuId = #{stuId}")
    public int updateStudent(Student student);
}
