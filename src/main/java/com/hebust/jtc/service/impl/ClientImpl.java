package com.hebust.jtc.service.impl;

import com.hebust.jtc.DAO.ClientMapper;
import com.hebust.jtc.DAO.StudentMapper;
import com.hebust.jtc.pojo.Client;
import com.hebust.jtc.service.ClientService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: 小天
 * @Date: 2023/6/5 - 06 - 05 - 6:19
 * @Decsription: com.hebust.jtc.service.impl
 * @version: 1.0
 */
@Component
public class ClientImpl implements ClientService {

    @Resource
    ClientMapper clientMapper;

    @Override
    public int addClient(Client client) {
        return clientMapper.addClient(client);
    }

    @Override
    public List<Client> getClient(String deptId) {
        return clientMapper.getClient(deptId);
    }
}
