package com.kennen.novel.common;

import java.util.List;

public class ListHelper {

    public static Boolean isNotEmpty(List list){
        return list != null && list.size() > 0;
    }

    public static Boolean isEmpty(List list){
        return list == null || list.size() <= 0;
    }
}
