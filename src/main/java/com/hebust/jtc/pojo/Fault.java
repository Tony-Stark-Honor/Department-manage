package com.hebust.jtc.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @Auther: 小天
 * @Date: 2023/5/15 - 05 - 15 - 21:29
 * @Decsription: com.hebust.jtc.pojo
 * @version: 1.0
 */
@Data
public class Fault {
    @TableId
    private Integer id;
    private String stuId;
    private String deptId;
    private String managerId;
    private String faultInfo;
    private String faultImage;
    private String date;
    private String maintainerId;
    private Integer uploadStatus;
    private Integer handleStatus;
    private Integer modifyStatus;
}
