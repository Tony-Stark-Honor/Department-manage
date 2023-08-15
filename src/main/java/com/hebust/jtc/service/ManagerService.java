package com.hebust.jtc.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hebust.jtc.pojo.Manager;

import java.util.List;

/**
 * @Auther: 小天
 * @Date: 2023/4/26 - 04 - 26 - 10:57
 * @Decsription: com.hebust.jtc.service
 * @version: 1.0
 */
public interface ManagerService {
    //管理员登录
    public List<Manager> managerLogin(String id, String password);
    //显示所有管理员
    public IPage<Manager> showManager(Integer pageNum, Integer pageSize);
    public List<Manager> show();
    //根据ID查询管理员
    public List<Manager> getByManagerId(String managerId);
    //添加管理员
    public int addManager(Manager manager);

    public int deleteManager(String managerId);
}
