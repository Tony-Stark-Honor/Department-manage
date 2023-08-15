package com.hebust.jtc.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hebust.jtc.DAO.MaintainerMapper;
import com.hebust.jtc.pojo.Maintainer;
import com.hebust.jtc.service.MaintainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: 小天
 * @Date: 2023/5/21 - 05 - 21 - 19:43
 * @Decsription: com.hebust.jtc.service.impl
 * @version: 1.0
 */
@Component
public class MaintainerImpl implements MaintainerService {
    @Resource
    MaintainerMapper maintainerMapper;

    @Override
    public IPage<Maintainer> getAllMaintainer(Integer pageNum, Integer pageSize) {
        IPage page = new Page(pageNum,pageSize);
        return maintainerMapper.getAllMaintainer(page);
    }

    @Override
    public List<Maintainer> getMaintainer() {
        return maintainerMapper.getMaintainer();
    }
    @Override
    public int updateMaintainer(Maintainer maintainer) {
        return maintainerMapper.updateMaintainer(maintainer);
    }

    @Override
    public int insertMaintainer(Maintainer maintainer) {
        return maintainerMapper.insertMaintainer(maintainer);
    }

    @Override
    public int deleteMaintainer(String maintainerId) {
        return maintainerMapper.deleteMaintainer(maintainerId);
    }

    @Override
    public List<Maintainer> getByMaintainerId(String maintainerId) {
        return maintainerMapper.getByMaintainerId(maintainerId);
    }
}
