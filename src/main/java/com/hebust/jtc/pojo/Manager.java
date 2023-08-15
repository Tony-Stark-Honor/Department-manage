package com.hebust.jtc.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @Auther: 小天
 * @Date: 2023/4/26 - 04 - 26 - 11:00
 * @Decsription: com.hebust.jtc.pojo
 * @version: 1.0
 */
@Data
public class Manager {
    @TableId
    private String managerId;
    private String managerName;
    private String password;
}
