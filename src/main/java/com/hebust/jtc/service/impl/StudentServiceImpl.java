package com.hebust.jtc.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hebust.jtc.DAO.StudentMapper;
import com.hebust.jtc.pojo.Fault;
import com.hebust.jtc.pojo.Student;
import com.hebust.jtc.pojo.Temperature;
import com.hebust.jtc.service.StudentService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: 小天
 * @Date: 2023/4/25 - 04 - 25 - 23:38
 * @Decsription: com.hebust.jtc.service.impl
 * @version: 1.0
 */
@Component
public class StudentServiceImpl implements StudentService {
    @Override
    public int addStudent(Student student){
        return studentMapper.addStudent(student);
    }

    @Resource
    StudentMapper studentMapper;
    @Override
    public int studentLogin(Student student) {
        return studentMapper.studentLogin(student);
    }
    @Override
    public IPage<Student> getAllStudent(Integer pageNum,Integer pageSize) {
        IPage page = new Page(pageNum,pageSize);
        return studentMapper.getAllStudent(page);
    }
    @Override
    public List<Student> getStudentByAny(String key,String value) {
        return studentMapper.getStudentByAny(key,value);
    }

    @Override
    public int deleteStudent(String stuId) {
        return studentMapper.deleteStudent(stuId);
    }
    @Override
    public int updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    @Override
    public int manageStudent(String stuId,String managerId, String deptId) {
        return studentMapper.manageStudent(stuId,managerId,deptId);
    }
}
