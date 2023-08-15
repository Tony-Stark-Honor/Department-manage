package com.hebust.jtc.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @Auther: 小天
 * @Date: 2023/5/15 - 05 - 15 - 12:38
 * @Decsription: com.hebust.jtc.pojo
 * @version: 1.0
 */
@Data
public class Temperature {
    @TableId
    private Integer id;
    private String stuId;
    private Double temperature;
    private String date;
}
