package com.hebust.jtc.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hebust.jtc.controller.Utils.PageResult;
import com.hebust.jtc.controller.Utils.R;
import com.hebust.jtc.pojo.*;
import com.hebust.jtc.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @Auther: 小天
 * @Date: 2023/4/26 - 04 - 26 - 0:14
 * @Decsription: com.hebust.jtc.controller
 * @version: 1.0
 */
@Controller
@CrossOrigin
@RequestMapping("/deptManage/student")
public class StudentController {
    @Autowired
    StudentServiceImpl studentService;

    @PostMapping("/add")
    @ResponseBody
    public R addStudent(@RequestBody Student student){
        R addStudentResult;
        System.out.println(student.getManagerId());
        int flag = studentService.addStudent(student);
        if (flag == 1){//成功
            addStudentResult = new R(true,"添加成功",flag);
        }else{
            addStudentResult = new R(false,"添加失败",0);
        }
        return addStudentResult;
    }

    @PostMapping("/login")
    @ResponseBody
    public R managerLogin(@RequestBody Student student){
        R studentLoginResult;
        System.out.println(student);
        int flag = studentService.studentLogin(student);
        System.out.println(flag);
        if (flag == 1){//成功
            System.out.println("日志：管理员"+student.getStuId()+"登录成功");
            studentLoginResult = new R(true,"登录成功",1);
        }else{
            studentLoginResult = new R(false,"登录失败",0);
        }
        return studentLoginResult;
    }

    @GetMapping("/show")
    @ResponseBody
    public R showAllStudent(@RequestParam(required = false)Integer pageNum,@RequestParam(required = false) Integer pageSize){
        PageResult selectStudentResult = new PageResult();
        IPage<Student> page = studentService.getAllStudent(pageNum,pageSize);
        if (page == null){
            selectStudentResult.setStatus(false);
            selectStudentResult.setInfo("查询失败");
            selectStudentResult.setCount(0);
            selectStudentResult.setData(0);
            selectStudentResult.setTotalRecordNum(0);
        } else if (page.getSize() == 0) {
            selectStudentResult.setStatus(true);
            selectStudentResult.setInfo("未添加数据");
            selectStudentResult.setCount(0);
            selectStudentResult.setData(0);
            selectStudentResult.setTotalRecordNum(0);
        }else {
            selectStudentResult.setStatus(true);
            selectStudentResult.setInfo("查询成功");
            List<Student> course = page.getRecords();
            selectStudentResult.setData(course);
            selectStudentResult.setCount(course.size());
            selectStudentResult.setTotalRecordNum(page.getTotal());
        }
        return selectStudentResult;
    }



    @GetMapping("/showBy")
    @ResponseBody
    public R getStudentByAny(@RequestParam(required = false)String key,@RequestParam(required = false)String value){
        R getStudentResult;
        List<Student> list = studentService.getStudentByAny(key,value);
        if (list.size() > 0){//成功
            getStudentResult = new R(true,"查询成功",list);
        }else{
            getStudentResult = new R(false,"查询失败",null);
        }
        return getStudentResult;
    }

    @GetMapping("/manage")
    @ResponseBody
    public R manageStudent(@RequestParam(required = false)String stuId,@RequestParam(required = false)String managerId,@RequestParam(required = false)String deptId){
        R manageStudentResult;
        int flag= studentService.manageStudent(stuId,managerId,deptId);
        if (flag == 1){//成功

            manageStudentResult = new R(true,"登录成功",1);
        }else{
            manageStudentResult = new R(false,"登录失败",0);
        }
        return manageStudentResult;
    }

    @GetMapping("delete")
    @ResponseBody
    public R deleteStudent(@RequestParam(required = false)String stuId){
        R manageStudentResult;
        int flag= studentService.deleteStudent(stuId);
        if (flag == 1){//成功
            manageStudentResult = new R(true,"删除成功",1);
        }else{
            manageStudentResult = new R(false,"删除失败",0);
        }
        return manageStudentResult;
    }

    @PostMapping("/update")
    @ResponseBody
    public R updateStudent(@RequestBody Student student){
        R updateStudentResult;
        System.out.println(student);
        int flag = studentService.updateStudent(student);
        if (flag == 1){//成功
            updateStudentResult = new R(true,"添加成功",flag);
        }else{
            updateStudentResult = new R(false,"添加失败",0);
        }
        return updateStudentResult;
    }
}
