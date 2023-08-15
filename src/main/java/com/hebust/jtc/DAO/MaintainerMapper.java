package com.hebust.jtc.DAO;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hebust.jtc.pojo.Maintainer;
import org.apache.ibatis.annotations.*;

import java.util.List;


/**
 * @Auther: 小天
 * @Date: 2023/5/21 - 05 - 21 - 19:36
 * @Decsription: com.hebust.jtc.DAO
 * @version: 1.0
 */
@Mapper
public interface MaintainerMapper extends BaseMapper<Maintainer> {
//    获取所有维修人员信息
    @Select("select * from maintainer")
    public IPage<Maintainer> getAllMaintainer(IPage page);
    //    获取所有维修人员信息
    @Select("select * from maintainer")
    public List<Maintainer> getMaintainer();

    @Select("select * from maintainer where maintainerId = #{maintainerId}")
    public List<Maintainer> getByMaintainerId(String maintainerId);

//    修改人员信息
    @Update("update maintainer set maintainerName = #{maintainerName},gender = #{gender} where maintainerId = #{maintainerId}")
    public int updateMaintainer(Maintainer maintainer);

//    新增人员信息
    @Insert("insert maintainer values (#{maintainerId},#{maintainerName},#{gender})")
    public int insertMaintainer(Maintainer maintainer);
//    删除人员信息
    @Delete("delete from maintainer where maintainerId = #{maintainerId}")
    public int deleteMaintainer(String maintainerId);

}
