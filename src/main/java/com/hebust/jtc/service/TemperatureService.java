package com.hebust.jtc.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hebust.jtc.pojo.Temperature;
import org.springframework.context.annotation.Bean;

/**
 * @Auther: 小天
 * @Date: 2023/5/17 - 05 - 17 - 11:43
 * @Decsription: com.hebust.jtc.service
 * @version: 1.0
 */

public interface TemperatureService {
    //体温登记
    public int uploadTemperature(Temperature temperature);
    //查询所有体温信息
    public IPage<Temperature> getAllTemperature(Integer pageNum, Integer pageSize);
}
