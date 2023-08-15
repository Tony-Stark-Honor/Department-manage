package com.hebust.jtc.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @Auther: 小天
 * @Date: 2023/5/11 - 05 - 11 - 23:13
 * @Decsription: com.hebust.jtc.pojo
 * @version: 1.0
 */
@Data
public class Dept {
    @TableId
    private String deptId;
    private Integer deptType;
    private Integer deptCapacity;
    private Integer deptStuNum;
    private String managerId;
}
