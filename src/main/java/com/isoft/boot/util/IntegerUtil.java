package com.isoft.boot.util;

public class IntegerUtil {
    public static boolean checkId(Integer id) {
        if(id == null || id < 1) {
            return false ;
        }
        return true;
    }
}
