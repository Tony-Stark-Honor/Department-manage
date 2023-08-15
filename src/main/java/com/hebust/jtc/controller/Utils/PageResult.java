package com.hebust.jtc.controller.Utils;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PageResult extends R{
    private int count;
    private long totalRecordNum;

    public PageResult(Boolean status, String info, Object data, int count, long totalRecordNum) {
        super(status, info, data);
        this.count = count;
        this.totalRecordNum = totalRecordNum;
    }

}
