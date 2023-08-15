package com.hebust.jtc.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @Auther: 小天
 * @Date: 2023/5/27 - 05 - 27 - 0:03
 * @Decsription: com.hebust.jtc.pojo
 * @version: 1.0
 */
@Data
public class PurchaseRecord {
    @TableId
    private Integer id;
    private String purchaserId;
    private String sellerId;
    private Integer goodsId;
    private Double goodsPrice;
}
