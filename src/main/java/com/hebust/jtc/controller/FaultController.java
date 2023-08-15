package com.hebust.jtc.controller;

import com.hebust.jtc.controller.Utils.R;
import com.hebust.jtc.pojo.Fault;
import com.hebust.jtc.service.impl.FaultServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @Auther: 小天
 * @Date: 2023/5/15 - 05 - 15 - 22:31
 * @Decsription: com.hebust.jtc.controller
 * @version: 1.0
 */
@Controller
@CrossOrigin
@RequestMapping("/deptManage/fault")
public class FaultController {
    @Autowired
    FaultServiceImpl faultService;

    //上传报修
    @PostMapping("/upload")
    @ResponseBody
    public R uploadFault(@RequestBody Fault fault){
        R uploadFaultResult;
        System.out.println(fault);
        java.util.Date Dates = new java.util.Date();
        System.out.println(Dates);
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
        String mydate = ft.format(Dates);  //转成指定格式的字符串
        System.out.println(mydate);
        fault.setDate(mydate);
        int flag = faultService.uploadFault(fault);
        if (flag == 1){//成功
            uploadFaultResult = new R(true,"添加成功",flag);
        }else{
            uploadFaultResult = new R(false,"添加失败",0);
        }
        return uploadFaultResult;
    }
    //获取我的报修
    @GetMapping("/get")
    @ResponseBody
    public R getmyfault(String stuId){
        R selectFaultResult;
        List<Fault> faultList = faultService.getMyFault(stuId);
        if (faultList.size() > 0){//成功
            selectFaultResult = new R(true,"查询成功",faultList);
        }else{
            selectFaultResult = new R(false,"查询失败",null);
        }
        return selectFaultResult;
    }
    //获取所有保修
    @GetMapping("/show")
    @ResponseBody
    public R show(){
        R selectFaultResult;
        List<Fault> faultList = faultService.getAllFault();
        if (faultList.size() > 0){//成功
            selectFaultResult = new R(true,"查询成功",faultList);
        }else{
            selectFaultResult = new R(false,"查询失败",null);
        }
        return selectFaultResult;
    }

    //处理报修
    @GetMapping("/handle")
    @ResponseBody
    public R handleFault(@RequestParam Integer id,@RequestParam String maintainerId){
        System.out.println(id);
        System.out.println(maintainerId);
        R handleFaultResult;
        int flag = faultService.handleFault(id,maintainerId);
        if (flag == 1){//成功
            handleFaultResult = new R(true,"处理成功",flag);
        }else{
            handleFaultResult = new R(false,"处理失败",flag);
        }
        return handleFaultResult;
    }

    //确认报修
    @RequestMapping("/modify")
    @ResponseBody
    public R modifyFault(Integer id){
        R modifyFaultResult;
        int flag = faultService.modifyFault(id);
        if (flag == 1){//成功
            modifyFaultResult = new R(true,"维修成功",flag);
        }else{
            modifyFaultResult = new R(false,"查询失败",flag);
        }
        return modifyFaultResult;
    }


}
