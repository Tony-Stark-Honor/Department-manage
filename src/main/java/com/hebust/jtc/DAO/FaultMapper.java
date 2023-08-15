package com.hebust.jtc.DAO;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hebust.jtc.pojo.Fault;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Auther: 小天
 * @Date: 2023/5/15 - 05 - 15 - 22:30
 * @Decsription: com.hebust.jtc.DAO
 * @version: 1.0
 */
@Mapper
public interface FaultMapper extends BaseMapper<Fault> {
    @Insert("insert into fault (stuId,deptId,faultInfo,faultImage,date) values (#{stuId},#{deptId},#{faultInfo},#{faultImage},#{date})")
    public int uploadFault(Fault fault);

    @Select("select * from fault where stuId = #{stuId}")
    public List<Fault> getMyFault(String stuId);

    @Select("select * from fault where handleStatus = 0")
    public List<Fault> getAllFault();

    @Update("update fault set handleStatus = 1 , maintainerId = #{maintainerId} where id = #{id}")
    public int handleFault(Integer id,String maintainerId);

    @Update("update fault set modifyStatus = 1 where id = #{id}")
    public int modifyFault(Integer id);
}
