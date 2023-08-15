package com.hebust.jtc.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @Auther: 小天
 * @Date: 2023/5/18 - 05 - 18 - 13:48
 * @Decsription: com.hebust.jtc.pojo
 * @version: 1.0
 */
@Data
public class Goods {
    @TableId
    private Integer goodsId;
    private String stuId;
    private String deptId;
    private String goodsName;
    private String goodsPic;
    private String goodsDetail;
    private Double goodsPrice;
    private Integer permission;
    private Integer status;
}
