package com.hebust.jtc.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hebust.jtc.pojo.Student;

import java.util.List;

/**
 * @Auther: 小天
 * @Date: 2023/4/25 - 04 - 25 - 23:39
 * @Decsription: com.hebust.jtc.service
 * @version: 1.0
 */
public interface StudentService {
    // 添加学生信息
    public int addStudent(Student student);
    //学生登录
    public int studentLogin(Student student);
    //获取所有学生信息
    IPage<Student> getAllStudent(Integer pageNum, Integer pageSize);
    //查找学生
    public List<Student> getStudentByAny(String key,String value);
    //删除学生信息
    public int deleteStudent(String stuId);
    //更改学生信息
    public int updateStudent(Student student);
    //管理学生
    public int manageStudent(String stuId,String managerId,String deptId);

}
