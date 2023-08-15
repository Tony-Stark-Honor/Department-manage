package com.hebust.jtc.DAO;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hebust.jtc.pojo.Manager;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther: 小天
 * @Date: 2023/4/26 - 04 - 26 - 10:58
 * @Decsription: com.hebust.jtc.DAO
 * @version: 1.0
 */
@Mapper
public interface ManagerMapper extends BaseMapper<Manager> {
    @Select("select * from manager where managerId = #{managerId} and password = #{password} ")
    public List<Manager> getManager(String managerId,String password);

    @Select("select * from manager where managerId != 'admin'")
    public IPage<Manager> showManager(IPage page);

    @Select("select * from manager where managerId != 'admin'")
    public List<Manager> show();

    @Select("select * from manager where managerId = #{managerId}")
    public List<Manager> getByManagerId(String managerId);

    @Insert("insert into manager(managerId,managerName,password) values(#{managerId},#{managerName},#{password})")
    public int addManager(Manager manager);

    @Delete("delete from manager where managerId = #{managerId} ")
    public int deleteManager(String managerId);
}
