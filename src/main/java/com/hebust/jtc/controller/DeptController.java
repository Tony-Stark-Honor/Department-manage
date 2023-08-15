package com.hebust.jtc.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hebust.jtc.controller.Utils.PageResult;
import com.hebust.jtc.controller.Utils.R;
import com.hebust.jtc.pojo.Dept;
import com.hebust.jtc.service.impl.DeptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: 小天
 * @Date: 2023/5/11 - 05 - 11 - 23:25
 * @Decsription: com.hebust.jtc.controller
 * @version: 1.0
 */
@Controller
@CrossOrigin
@RequestMapping("/deptManage/dept")
public class DeptController {
    @Autowired
    DeptServiceImpl deptService;

    @GetMapping("/show")
    @ResponseBody
    public R showDept(@RequestParam(required = false)Integer pageNum, @RequestParam(required = false) Integer pageSize){
        PageResult selectDeptResult = new PageResult();
        IPage<Dept> page = deptService.getAllDept(pageNum,pageSize);
        if (page == null){
            selectDeptResult.setStatus(false);
            selectDeptResult.setInfo("查询失败");
            selectDeptResult.setCount(0);
            selectDeptResult.setData(0);
            selectDeptResult.setTotalRecordNum(0);
        } else if (page.getSize() == 0) {
            selectDeptResult.setStatus(true);
            selectDeptResult.setInfo("未添加数据");
            selectDeptResult.setCount(0);
            selectDeptResult.setData(0);
            selectDeptResult.setTotalRecordNum(0);
        }else {
            selectDeptResult.setStatus(true);
            selectDeptResult.setInfo("查询成功");
            List<Dept> deptList = page.getRecords();
            selectDeptResult.setData(deptList);
            selectDeptResult.setCount(deptList.size());
            selectDeptResult.setTotalRecordNum(page.getTotal());
        }
        return selectDeptResult;
    }
    @GetMapping("/get")
    @ResponseBody
    public R show(){
        R selectDeptResult;
        List<Dept> deptList = deptService.getDept();
        if (deptList.size() > 0){//成功
            selectDeptResult = new R(true,"查询成功",deptList);
        }else{
            selectDeptResult = new R(false,"查询失败",null);
        }
        return selectDeptResult;
    }

    @GetMapping("/getByDeptId")
    @ResponseBody
    public R getByDeptId(@RequestParam String deptId){
        R selectDeptResult = new R();
        List<Dept> deptList = deptService.getByDeptId(deptId);
        if (deptList.size() > 0){//成功
            selectDeptResult = new R(true,"查询成功",deptList);
        }else{
            selectDeptResult = new R(false,"查询失败",null);
        }
        return selectDeptResult;
    }

    @GetMapping("/show/managerid")
    @ResponseBody
    public R showDeptByManagerId(@RequestParam(required = true) String managerId,@RequestParam(required = false)Integer pageNum, @RequestParam(required = false) Integer pageSize){
        PageResult selectDeptByManagerIdResult = new PageResult();
        IPage<Dept> page = deptService.getDeptByManagerId(managerId,pageNum,pageSize);
        if (page == null){
            selectDeptByManagerIdResult.setStatus(false);
            selectDeptByManagerIdResult.setInfo("查询失败");
            selectDeptByManagerIdResult.setCount(0);
            selectDeptByManagerIdResult.setData(0);
            selectDeptByManagerIdResult.setTotalRecordNum(0);
        } else if (page.getSize() == 0) {
            selectDeptByManagerIdResult.setStatus(true);
            selectDeptByManagerIdResult.setInfo("未添加数据");
            selectDeptByManagerIdResult.setCount(0);
            selectDeptByManagerIdResult.setData(0);
            selectDeptByManagerIdResult.setTotalRecordNum(0);
        }else {
            selectDeptByManagerIdResult.setStatus(true);
            selectDeptByManagerIdResult.setInfo("查询成功");
            List<Dept> deptList = page.getRecords();
            selectDeptByManagerIdResult.setData(deptList);
            selectDeptByManagerIdResult.setCount(deptList.size());
            selectDeptByManagerIdResult.setTotalRecordNum(page.getTotal());
        }
        return selectDeptByManagerIdResult;
    }
    @PostMapping("/add")
    @ResponseBody
    public R addDept(@RequestBody Dept dept){
        R addDeptResult;
        int flag = deptService.addDept(dept);
        if (flag == 1){//成功
            addDeptResult = new R(true,"添加成功",flag);
        }else{
            addDeptResult = new R(false,"添加失败",0);
        }
        return addDeptResult;
    }

    @PostMapping("/update")
    @ResponseBody
    public R updateDept(@RequestBody Dept dept){
        R addDeptResult;
        int flag = deptService.updateDept(dept);
        if (flag == 1){//成功
            addDeptResult = new R(true,"添加成功",flag);
        }else{
            addDeptResult = new R(false,"添加失败",0);
        }
        return addDeptResult;
    }

    @PostMapping("/setManager")
    @ResponseBody
    public R setManager(@RequestBody Dept dept){
        R manageDeptResult;
        System.out.println(dept);
        int flag = deptService.setManager(dept);
        if (flag == 1){//成功
            manageDeptResult = new R(true,"设置成功",flag);
        }else{
            manageDeptResult = new R(false,"设置失败",0);
        }
        return manageDeptResult;
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public R deleteDept(@RequestParam String  deptId){
        R deleteDeptResult;
        int flag = deptService.deleteDept(deptId);
        if (flag == 1){//成功
            deleteDeptResult = new R(true,"删除成功",flag);
        }else{
            deleteDeptResult = new R(false,"删除失败",0);
        }
        return deleteDeptResult;
    }
}
