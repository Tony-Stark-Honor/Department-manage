package com.hebust.jtc.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @Auther: 小天
 * @Date: 2023/5/21 - 05 - 21 - 19:34
 * @Decsription: com.hebust.jtc.pojo
 * @version: 1.0
 */
@Data
public class Maintainer {
    @TableId
    private String maintainerId;
    private String maintainerName;
    private String gender;
}
