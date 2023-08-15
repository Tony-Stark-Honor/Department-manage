package com.hebust.jtc.controller;

import com.hebust.jtc.controller.Utils.R;
import com.hebust.jtc.pojo.Client;
import com.hebust.jtc.pojo.Score;
import com.hebust.jtc.service.ScoreService;
import com.hebust.jtc.service.impl.ClientImpl;
import com.hebust.jtc.service.impl.ScoreImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @Auther: 小天
 * @Date: 2023/6/5 - 06 - 05 - 6:41
 * @Decsription: com.hebust.jtc.controller
 * @version: 1.0
 */
@Controller
@CrossOrigin
@RequestMapping("/deptManage/score")
public class ScoreController {
    @Autowired
    ScoreImpl scoreService;

    @PostMapping("/add")
    @ResponseBody
    public R addScore(@RequestBody Score score){
        R addScoreResult;
        java.util.Date Dates = new java.util.Date();
        System.out.println(Dates);
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
        String mydate = ft.format(Dates);  //转成指定格式的字符串
        System.out.println(mydate);
        score.setDate(mydate);
        System.out.println(score);
        int flag = scoreService.addScore(score);
        if (flag == 1){//成功
            addScoreResult = new R(true,"添加成功",flag);
        }else{
            addScoreResult = new R(false,"添加失败",0);
        }
        return addScoreResult;
    }

    @GetMapping("get")
    @ResponseBody
    public R getScore(String deptId){
        R getScoreResult;
        List<Score> list = scoreService.getScore(deptId);
        if (list.size() > 0){//成功
            getScoreResult = new R(true,"查询成功",list);
        }else{
            getScoreResult = new R(false,"查询失败",null);
        }
        return getScoreResult;
    }

}
