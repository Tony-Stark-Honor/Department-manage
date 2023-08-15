package com.hebust.jtc.DAO;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hebust.jtc.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Auther: 小天
 * @Date: 2023/5/11 - 05 - 11 - 23:18
 * @Decsription: com.hebust.jtc.DAO
 * @version: 1.0
 */
@Mapper
public interface DeptMapper extends BaseMapper<Dept> {
//    获取宿舍信息
    @Select("select * from department")
    public IPage<Dept> getAllDept(IPage page);
    @Select("select * from department")
//    根据宿舍Id获取信息
    public List<Dept> getDept();
    @Select("select * from department where deptId = #{deptId}")
    public List<Dept> getByDeptId(String deptId);
    @Select("select * from department where managerId = #{managerId}")
    public IPage<Dept> getDeptByManagerId(String managerId, IPage page);
    @Insert ("Insert into department (deptId,deptType,deptCapacity,deptStuNum,managerId) values(#{deptId},#{deptType},#{deptCapacity},#{deptStuNum},#{managerId})")
    public int addDept(Dept dept);
    @Update("update department set deptType=#{deptType},deptCapacity = #{deptCapacity},deptStuNum=#{deptStuNum},managerId=#{managerId} where deptId = #{deptId}")
    public int updateDept(Dept dept);
    @Update("update department set managerId = #{managerId} where deptId = #{deptId}")
    public int setManager(Dept dept);
    @Delete("delete from department where deptId = #{deptId}")
    public int deleteDept(String deptId);
}
