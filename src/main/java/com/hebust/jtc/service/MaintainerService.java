package com.hebust.jtc.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hebust.jtc.pojo.Maintainer;
import com.hebust.jtc.pojo.Manager;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Auther: 小天
 * @Date: 2023/5/21 - 05 - 21 - 19:43
 * @Decsription: com.hebust.jtc.service
 * @version: 1.0
 */
public interface MaintainerService {
    //    获取所有维修人员信息
    public IPage<Maintainer> getAllMaintainer(Integer pageNum, Integer pageSize);
    public List<Maintainer> getMaintainer();
    //    修改人员信息
    public int updateMaintainer(Maintainer maintainer);
    //    新增人员信息
    public int insertMaintainer(Maintainer maintainer);
    //    删除人员信息
    public int deleteMaintainer(String maintainerId);

    public List<Maintainer> getByMaintainerId(String maintainerId);
}
