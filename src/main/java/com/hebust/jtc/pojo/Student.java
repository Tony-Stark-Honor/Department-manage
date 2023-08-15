package com.hebust.jtc.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @Author: 吉天赐
 * @Date: 2023/4/25 - 04 - 25 - 23:42
 * @Decsription: com.hebust.jtc.pojo
 * @version: 1.0
 */
@Data
public class Student {
    @TableId
    private String stuId;
    private String stuName;
    private String stuGender;
    private String stuPwd;
    private Double account;
    private String deptId;
    private String managerId;
}
