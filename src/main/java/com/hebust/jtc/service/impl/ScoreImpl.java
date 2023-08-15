package com.hebust.jtc.service.impl;

import com.hebust.jtc.DAO.ClientMapper;
import com.hebust.jtc.DAO.ScoreMapper;
import com.hebust.jtc.pojo.Client;
import com.hebust.jtc.pojo.Score;
import com.hebust.jtc.service.ClientService;
import com.hebust.jtc.service.ScoreService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: 小天
 * @Date: 2023/6/5 - 06 - 05 - 6:40
 * @Decsription: com.hebust.jtc.service.impl
 * @version: 1.0
 */
@Component
public class ScoreImpl implements ScoreService {

    @Resource
    ScoreMapper scoreMapper;

    @Override
    public int addScore(Score score) {
        return scoreMapper.addScore(score);
    }

    @Override
    public List<Score> getScore(String deptId) {
        return scoreMapper.getScore(deptId);
    }
}
