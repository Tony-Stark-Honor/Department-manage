package com.hebust.jtc.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @Auther: 小天
 * @Date: 2023/6/5 - 06 - 05 - 0:59
 * @Decsription: com.hebust.jtc.pojo
 * @version: 1.0
 */
@Data
public class Client {
    @TableId
    private String stuId;
    private String deptId;
    private String date;
}
