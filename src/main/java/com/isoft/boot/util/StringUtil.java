package com.isoft.boot.util;

public class StringUtil {
    public static boolean isEmpty(String str) {
        if(str == null || str.trim().length() == 0) {
            return true ;
        }
        return false ;
    }

    public static Integer str2Int(String str) {
        Integer i = null ;
        try {
            i = Integer.parseInt(str) ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i ;
    }

}
