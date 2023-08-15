package com.hebust.jtc.service;

import com.hebust.jtc.pojo.Client;
import com.hebust.jtc.pojo.Score;

import java.util.List;

/**
 * @Auther: 小天
 * @Date: 2023/6/5 - 06 - 05 - 6:41
 * @Decsription: com.hebust.jtc.service
 * @version: 1.0
 */

public interface ScoreService {
    //    添加访客记录
    public int addScore(Score score);
    //    获取访客记录
    public List<Score> getScore(String deptId);
}
