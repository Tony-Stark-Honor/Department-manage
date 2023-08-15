package com.hebust.jtc.service;

import com.hebust.jtc.pojo.Fault;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: 小天
 * @Date: 2023/5/15 - 05 - 15 - 22:30
 * @Decsription: com.hebust.jtc.service
 * @version: 1.0
 */
@Component
public interface FaultService {
    //体温登记
    public int uploadFault(Fault fault);

    //获取我的保修信息
    public List<Fault> getMyFault(String stuId);

    //获取所有报修信息
    public List<Fault> getAllFault();

    //处理报修
    public int handleFault(Integer id,String maintainerId);

    //确认报修
    public int modifyFault(Integer id);
}
