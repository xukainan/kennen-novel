package com.kennen.novel.common;

import lombok.Getter;

@Getter
public enum DELETEENUMS {
    Deleted(1, "Deleted"),
    NotDelete(0, "NotDelete");


    private int status;
    private String statusName;

    DELETEENUMS(int status, String statusName) {
        this.status = status;
        this.statusName = statusName;
    }
}
