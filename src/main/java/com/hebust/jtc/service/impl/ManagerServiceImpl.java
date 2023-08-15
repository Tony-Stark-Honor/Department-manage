package com.hebust.jtc.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hebust.jtc.DAO.ManagerMapper;
import com.hebust.jtc.pojo.Manager;
import com.hebust.jtc.service.ManagerService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;


/**
 * @Auther: 小天
 * @Date: 2023/4/26 - 04 - 26 - 10:57
 * @Decsription: com.hebust.jtc.service.impl
 * @version: 1.0
 */
@Component
public class ManagerServiceImpl implements ManagerService {

    @Resource
    ManagerMapper managerMapper;



    @Override
    public List<Manager> managerLogin(String id, String password) {
        return managerMapper.getManager(id,password);
    }

    @Override
    public IPage<Manager> showManager(Integer pageNum,Integer pageSize) {
        IPage page = new Page(pageNum,pageSize);
        return managerMapper.showManager(page);
    }

    @Override
    public List<Manager> show() {
        return managerMapper.show();
    }

    @Override
    public List<Manager> getByManagerId(String managerId) {
        return managerMapper.getByManagerId(managerId);
    }

    @Override
    public int addManager(Manager manager) {
        return managerMapper.addManager(manager);
    }

    @Override
    public int deleteManager(String managerId) {
        return managerMapper.deleteManager(managerId);
    }
}
