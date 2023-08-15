package com.hebust.jtc.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hebust.jtc.controller.Utils.PageResult;
import com.hebust.jtc.controller.Utils.R;
import com.hebust.jtc.pojo.Dept;
import com.hebust.jtc.pojo.Manager;
import com.hebust.jtc.service.impl.ManagerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: 小天
 * @Date: 2023/4/26 - 04 - 26 - 11:14
 * @Decsription: com.hebust.jtc.controller
 * @version: 1.0
 */
@Controller
@CrossOrigin
@RequestMapping("/deptManage/manager")
public class ManagerController {
    @Autowired
    ManagerServiceImpl managerService;
//    管理员登录
    @PostMapping("/login")
    @ResponseBody
    public R managerLogin(@RequestBody Manager manager){
        R getCourseByIDResult;
        List<Manager> temp = managerService.managerLogin(manager.getManagerId(),manager.getPassword());
        if (temp.size() > 0){//成功
            System.out.println("日志：管理员"+manager.getManagerId()+"登录成功");
            getCourseByIDResult = new R(true,"登录成功",1);
        }else{
            getCourseByIDResult = new R(false,"登录失败",0);
        }
        return getCourseByIDResult;
    }
//    查看所有管理员
    @GetMapping("/show")
    @ResponseBody
    public R showManager(@RequestParam(required = false)Integer pageNum, @RequestParam(required = false) Integer pageSize){
        PageResult selectManagerResult = new PageResult();
        IPage<Manager> page = managerService.showManager(pageNum,pageSize);
        if (page == null){
            selectManagerResult.setStatus(false);
            selectManagerResult.setInfo("查询失败");
            selectManagerResult.setCount(0);
            selectManagerResult.setData(0);
            selectManagerResult.setTotalRecordNum(0);
        } else if (page.getSize() == 0) {
            selectManagerResult.setStatus(true);
            selectManagerResult.setInfo("未添加数据");
            selectManagerResult.setCount(0);
            selectManagerResult.setData(0);
            selectManagerResult.setTotalRecordNum(0);
        }else {
            selectManagerResult.setStatus(true);
            selectManagerResult.setInfo("查询成功");
            List<Manager> managerList = page.getRecords();
            selectManagerResult.setData(managerList);
            selectManagerResult.setCount(managerList.size());
            selectManagerResult.setTotalRecordNum(page.getTotal());
        }
        return selectManagerResult;
    }

    //    查看所有管理员
    @GetMapping("/get")
    @ResponseBody
    public R show(){
        R selectManagerResult;
        List<Manager> managerList = managerService.show();
        if (managerList.size() > 0){//成功
            selectManagerResult = new R(true,"查询成功",managerList);
        }else{
            selectManagerResult = new R(false,"查询失败",null);
        }
        return selectManagerResult;
    }

    //    添加楼长
    @PostMapping("/add")
    @ResponseBody
    public R addManager(@RequestBody Manager manager){
        R addManagerResult;

        int flag = managerService.addManager(manager);
        if(flag == 1){
            addManagerResult = new R(true,"添加成功",1);
        }else{
            addManagerResult = new R(false,"添加失败",0);
        }

        return addManagerResult;
    }

    //    查看所有管理员
    @GetMapping("/getByManagerId")
    @ResponseBody
    public R getByManagerId(@RequestParam String managerId){
        R selectManagerResult;
        List<Manager> managerList = managerService.getByManagerId(managerId);
        if (managerList.size() > 0){//成功
            selectManagerResult = new R(true,"查询成功",managerList);
        }else{
            selectManagerResult = new R(false,"查询失败",null);
        }
        return selectManagerResult;
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public R deleteManager(@RequestParam String  managerId){
        R deleteManagerResult;
        int flag = managerService.deleteManager(managerId);
        if (flag == 1){//成功
            deleteManagerResult = new R(true,"删除成功",flag);
        }else{
            deleteManagerResult = new R(false,"删除失败",0);
        }
        return deleteManagerResult;
    }
}
