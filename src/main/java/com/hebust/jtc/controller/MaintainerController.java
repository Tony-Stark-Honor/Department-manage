package com.hebust.jtc.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hebust.jtc.controller.Utils.PageResult;
import com.hebust.jtc.controller.Utils.R;
import com.hebust.jtc.pojo.Maintainer;
import com.hebust.jtc.service.impl.MaintainerImpl;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: 小天
 * @Date: 2023/5/21 - 05 - 21 - 19:46
 * @Decsription: com.hebust.jtc.controller
 * @version: 1.0
 */
@Controller
@CrossOrigin
@RequestMapping("/deptManage/maintainer")
public class MaintainerController {
    @Autowired
    MaintainerImpl maintainerService;

    @GetMapping("/show")
    @ResponseBody
    public R showDept(@RequestParam(required = false)Integer pageNum, @RequestParam(required = false) Integer pageSize){
        PageResult selectMaintainerResult = new PageResult();
        IPage<Maintainer> page = maintainerService.getAllMaintainer(pageNum,pageSize);
        if (page == null){
            selectMaintainerResult.setStatus(false);
            selectMaintainerResult.setInfo("查询失败");
            selectMaintainerResult.setCount(0);
            selectMaintainerResult.setData(0);
            selectMaintainerResult.setTotalRecordNum(0);
        } else if (page.getSize() == 0) {
            selectMaintainerResult.setStatus(true);
            selectMaintainerResult.setInfo("未添加数据");
            selectMaintainerResult.setCount(0);
            selectMaintainerResult.setData(0);
            selectMaintainerResult.setTotalRecordNum(0);
        }else {
            selectMaintainerResult.setStatus(true);
            selectMaintainerResult.setInfo("查询成功");
            List<Maintainer> maintainerList = page.getRecords();
            selectMaintainerResult.setData(maintainerList);
            selectMaintainerResult.setCount(maintainerList.size());
            selectMaintainerResult.setTotalRecordNum(page.getTotal());

        }
        return selectMaintainerResult;
    }

    @GetMapping("/get")
    @ResponseBody
    public R getDept(){
        R selectMaintainerResult;
        List<Maintainer> maintainerList = maintainerService.getMaintainer();
        if (maintainerList.size() > 0){//成功
            selectMaintainerResult = new R(true,"查询成功",maintainerList);
        }else{
            selectMaintainerResult = new R(false,"查询失败",null);
        }
        return selectMaintainerResult;
    }

    @GetMapping("/getByMaintainerId")
    @ResponseBody
    public R getByMaintainerId(@RequestParam String maintainerId){
        R getByMaintainerIdResult;
        List<Maintainer> maintainerList = maintainerService.getByMaintainerId(maintainerId);
        if (maintainerList.size() > 0){//成功
            getByMaintainerIdResult = new R(true,"查询成功",maintainerList);
        }else{
            getByMaintainerIdResult = new R(false,"查询失败",null);
        }
        return getByMaintainerIdResult;
    }

    @PostMapping("/add")
    @ResponseBody
    public R insertMaintainer(@RequestBody Maintainer maintainer){
        R addStudentResult;
        System.out.println("日志：管理员添加维修人员信息");
        int flag = maintainerService.insertMaintainer(maintainer);
        if (flag == 1){//成功
            addStudentResult = new R(true,"添加成功",flag);
        }else{
            addStudentResult = new R(false,"添加失败",0);
        }
        return addStudentResult;
    }

    @PostMapping("/update")
    @ResponseBody
    public R updateMaintainer(@RequestBody Maintainer maintainer){
        R addStudentResult;
        System.out.println("日志："+maintainer.getMaintainerId()+"修改信息");
        System.out.println(maintainer);
        int flag = maintainerService.updateMaintainer(maintainer);
        if (flag == 1){//成功
            addStudentResult = new R(true,"更新成功",flag);
        }else{
            addStudentResult = new R(false,"更新失败",0);
        }
        return addStudentResult;
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public R deleteMaintainer(@RequestParam String maintainerId){
        R deleteMaintainerResult;
        int flag = maintainerService.deleteMaintainer(maintainerId);
        if (flag == 1){//成功
            deleteMaintainerResult = new R(true,"删除成功",flag);
        }else{
            deleteMaintainerResult = new R(false,"删除失败",flag);
        }
        return deleteMaintainerResult;
    }
}
