package com.hebust.jtc.service.impl;

import com.hebust.jtc.DAO.FaultMapper;
import com.hebust.jtc.DAO.StudentMapper;
import com.hebust.jtc.pojo.Fault;
import com.hebust.jtc.service.FaultService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: 小天
 * @Date: 2023/5/15 - 05 - 15 - 22:30
 * @Decsription: com.hebust.jtc.service.impl
 * @version: 1.0
 */
@Component
public class FaultServiceImpl implements FaultService {

    @Resource
    FaultMapper faultMapper;

    @Override
    public int uploadFault(Fault fault) {
        return faultMapper.uploadFault(fault);
    }

    @Override
    public List<Fault> getMyFault(String stuId) {
        return faultMapper.getMyFault(stuId);
    }

    @Override
    public List<Fault> getAllFault() {
        return faultMapper.getAllFault();
    }

    @Override
    public int handleFault(Integer id,String maintainerId) {
        return faultMapper.handleFault(id,maintainerId);
    }

    @Override
    public int modifyFault(Integer id) {
        return faultMapper.modifyFault(id);
    }
}
