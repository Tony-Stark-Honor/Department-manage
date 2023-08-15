package com.hebust.jtc.controller.Utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class R {
    private Boolean status;
    private String info;
    private Object data;
    public R(Boolean status){
        this.setStatus(false);
    }
    public R(String info){
        this.setInfo(info);
        this.setStatus(false);
    }
}
