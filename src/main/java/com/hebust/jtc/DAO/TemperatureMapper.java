package com.hebust.jtc.DAO;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hebust.jtc.pojo.Temperature;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Auther: 小天
 * @Date: 2023/5/15 - 05 - 15 - 12:47
 * @Decsription: com.hebust.jtc.DAO.Utils
 * @version: 1.0
 */
@Mapper
public interface TemperatureMapper extends BaseMapper<Temperature> {
    @Insert("insert into temperature (stuId,temperature,date) values (#{stuId},#{temperature},#{date})")
    public int uploadTemperature(Temperature temperature);

    @Select("select * from temperature order by date desc")
    public IPage<Temperature> getAllTemperature(IPage page);
}
