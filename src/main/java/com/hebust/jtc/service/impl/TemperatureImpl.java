package com.hebust.jtc.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hebust.jtc.DAO.StudentMapper;
import com.hebust.jtc.DAO.TemperatureMapper;
import com.hebust.jtc.pojo.Temperature;
import com.hebust.jtc.service.TemperatureService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Auther: 小天
 * @Date: 2023/5/17 - 05 - 17 - 11:44
 * @Decsription: com.hebust.jtc.service.impl
 * @version: 1.0
 */
@Component
public class TemperatureImpl implements TemperatureService {
    @Resource
    TemperatureMapper temperatureMapper;
    @Override
    public int uploadTemperature(Temperature temperature) {
        return temperatureMapper.uploadTemperature(temperature);
    }

    @Override
    public IPage<Temperature> getAllTemperature(Integer pageNum, Integer pageSize) {
        IPage page = new Page(pageNum,pageSize);
        return temperatureMapper.getAllTemperature(page);
    }
}
