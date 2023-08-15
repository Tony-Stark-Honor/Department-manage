package com.hebust.jtc.DAO;

import com.hebust.jtc.pojo.Client;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther: 小天
 * @Date: 2023/6/5 - 06 - 05 - 6:19
 * @Decsription: com.hebust.jtc.DAO
 * @version: 1.0
 */
@Mapper
public interface ClientMapper {
    @Insert("insert into client(stuId,deptId,date) values(#{stuId},#{deptId},#{date})")
    public int addClient(Client client);

    @Select("select * from client where deptId = #{deptId} order by date desc")
    public List<Client> getClient(String deptId);
}
