package com.kennen.novel.common;

import lombok.Getter;

@Getter
public enum STATUSENUMS {

    Active(1, "Active"),
    InActive(0, "InActive");


    private int status;
    private String statusName;

    STATUSENUMS(int status, String statusName) {
        this.status = status;
        this.statusName = statusName;
    }

}
