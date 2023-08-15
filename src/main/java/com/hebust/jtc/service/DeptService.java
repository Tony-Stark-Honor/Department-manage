package com.hebust.jtc.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hebust.jtc.pojo.Dept;

import java.util.List;

/**
 * @Auther: 小天
 * @Date: 2023/5/11 - 05 - 11 - 23:19
 * @Decsription: com.hebust.jtc.service
 * @version: 1.0
 */
public interface DeptService {
    //查询宿舍
    public IPage<Dept> getAllDept(Integer pageNum, Integer pageSize);
    //获取宿舍信息
    public List<Dept> getDept();
    //根据宿舍Id获取信息
    public List<Dept> getByDeptId(String deptId);
    //查询宿舍
    public IPage<Dept> getDeptByManagerId(String managerId,Integer pageNum, Integer pageSize);
    //添加宿舍
    public int addDept(Dept dept);
    //修改宿舍信息
    public int updateDept(Dept dept);
    //设置管理员
    public int setManager(Dept dept);
    //删除宿舍
    public int deleteDept(String  deptId);
}
