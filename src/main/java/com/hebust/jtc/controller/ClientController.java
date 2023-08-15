package com.hebust.jtc.controller;

import com.hebust.jtc.controller.Utils.R;
import com.hebust.jtc.pojo.Client;
import com.hebust.jtc.pojo.Student;
import com.hebust.jtc.service.ClientService;
import com.hebust.jtc.service.impl.ClientImpl;
import com.hebust.jtc.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @Auther: 小天
 * @Date: 2023/6/5 - 06 - 05 - 6:20
 * @Decsription: com.hebust.jtc.controller.Utils
 * @version: 1.0
 */
@Controller
@CrossOrigin
@RequestMapping("/deptManage/client")
public class ClientController {
    @Autowired
    ClientImpl clientService;

    @PostMapping("/add")
    @ResponseBody
    public R addClient(@RequestBody Client client){
        R addClientResult;
        java.util.Date Dates = new java.util.Date();
        System.out.println(Dates);
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
        String mydate = ft.format(Dates);  //转成指定格式的字符串
        System.out.println(mydate);
        client.setDate(mydate);
        int flag = clientService.addClient(client);
        if (flag == 1){//成功
            addClientResult = new R(true,"添加成功",flag);
        }else{
            addClientResult = new R(false,"添加失败",0);
        }
        return addClientResult;
    }

    @GetMapping("get")
    @ResponseBody
    public R getClient(String deptId){
        R getClientResult;
        List<Client> list = clientService.getClient(deptId);
        if (list.size() > 0){//成功
            getClientResult = new R(true,"查询成功",list);
        }else{
            getClientResult = new R(false,"查询失败",null);
        }
        return getClientResult;
    }
}
