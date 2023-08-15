package com.hebust.jtc.DAO;

import com.hebust.jtc.pojo.Score;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther: 小天
 * @Date: 2023/6/5 - 06 - 05 - 6:41
 * @Decsription: com.hebust.jtc.DAO
 * @version: 1.0
 */
public interface ScoreMapper {
    @Insert("insert into score(deptId,score,date) values(#{deptId},#{score},#{date})")
    public int addScore(Score score);

    @Select("select * from score where deptId = #{deptId} order by date desc")
    public List<Score> getScore(String deptId);
}
