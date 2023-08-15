package com.hebust.jtc.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hebust.jtc.controller.Utils.PageResult;
import com.hebust.jtc.controller.Utils.R;
import com.hebust.jtc.pojo.Student;
import com.hebust.jtc.pojo.Temperature;
import com.hebust.jtc.service.TemperatureService;
import com.hebust.jtc.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @Auther: 小天
 * @Date: 2023/5/17 - 05 - 17 - 22:09
 * @Decsription: com.hebust.jtc.controller
 * @version: 1.0
 */
@Controller
@CrossOrigin
@RequestMapping("/deptManage/temperature")
public class TemperatureController {
    @Autowired
    TemperatureService temperatureService;

    @PostMapping("/upload")
    @ResponseBody
    public R uploadTemperature(@RequestBody Temperature temperature){
        R addStudentResult;
        System.out.println(temperature);
        java.util.Date Dates = new java.util.Date();
        System.out.println(Dates);
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
        String mydate = ft.format(Dates);  //转成指定格式的字符串
        System.out.println(mydate);
        temperature.setDate(mydate);
        int flag = temperatureService.uploadTemperature(temperature);
        if (flag == 1){//成功
            addStudentResult = new R(true,"添加成功",flag);
        }else{
            addStudentResult = new R(false,"添加失败",0);
        }
        return addStudentResult;
    }

    @GetMapping("/show")
    @ResponseBody
    public R showAllTemperature(@RequestParam(required = false)Integer pageNum,@RequestParam(required = false) Integer pageSize){
        System.out.println(pageNum);
        System.out.println(pageSize);
        PageResult selectTemperatureResult = new PageResult();
        IPage<Temperature> page = temperatureService.getAllTemperature(pageNum,pageSize);
        if (page == null){
            selectTemperatureResult.setStatus(false);
            selectTemperatureResult.setInfo("查询失败");
            selectTemperatureResult.setCount(0);
            selectTemperatureResult.setData(0);
            selectTemperatureResult.setTotalRecordNum(0);
        } else if (page.getSize() == 0) {
            selectTemperatureResult.setStatus(true);
            selectTemperatureResult.setInfo("未添加数据");
            selectTemperatureResult.setCount(0);
            selectTemperatureResult.setData(0);
            selectTemperatureResult.setTotalRecordNum(0);
        }else {
            selectTemperatureResult.setStatus(true);
            selectTemperatureResult.setInfo("查询成功");
            List<Temperature> temperatureList = page.getRecords();
            selectTemperatureResult.setData(temperatureList);
            selectTemperatureResult.setCount(temperatureList.size());
            selectTemperatureResult.setTotalRecordNum(page.getTotal());
        }
        return selectTemperatureResult;
    }
}
