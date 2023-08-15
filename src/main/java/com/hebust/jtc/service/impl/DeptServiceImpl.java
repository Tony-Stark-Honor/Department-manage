package com.hebust.jtc.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hebust.jtc.DAO.DeptMapper;
import com.hebust.jtc.pojo.Dept;
import com.hebust.jtc.service.DeptService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: 小天
 * @Date: 2023/5/11 - 05 - 11 - 23:18
 * @Decsription: com.hebust.jtc.service.impl
 * @version: 1.0
 */
@Component
public class DeptServiceImpl implements DeptService {

    @Resource
    DeptMapper deptMapper;

    @Override
    public IPage<Dept> getAllDept(Integer pageNum, Integer pageSize) {
        IPage page = new Page(pageNum,pageSize);
        return deptMapper.getAllDept(page);
    }

    @Override
    public List<Dept> getDept() {
        return deptMapper.getDept();
    }

    @Override
    public List<Dept> getByDeptId(String deptId) {
        return deptMapper.getByDeptId(deptId);
    }

    @Override
    public IPage<Dept> getDeptByManagerId(String managerId, Integer pageNum, Integer pageSize) {
        IPage page = new Page(pageNum,pageSize);
        return deptMapper.getDeptByManagerId(managerId,page);
    }

    @Override
    public int addDept(Dept dept) {
        return deptMapper.addDept(dept);
    }

    @Override
    public int updateDept(Dept dept) {
        return deptMapper.updateDept(dept);
    }

    @Override
    public int setManager(Dept dept) {
        return deptMapper.setManager(dept);
    }

    @Override
    public int deleteDept(String  deptId) {
        return deptMapper.deleteDept(deptId);
    }
}
