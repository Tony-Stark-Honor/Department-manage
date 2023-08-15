package com.hebust.jtc.service;

import com.hebust.jtc.pojo.Client;

import java.util.List;

/**
 * @Auther: 小天
 * @Date: 2023/6/5 - 06 - 05 - 6:19
 * @Decsription: com.hebust.jtc.service
 * @version: 1.0
 */
public interface ClientService {
//    添加访客记录
    public int addClient(Client client);
//    获取访客记录
    public List<Client> getClient(String deptId);
}
