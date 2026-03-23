package com.youlai.boot.common.util;

public class NumberUtil {

    public static boolean isIntNumeric(String str){
        if(str == null || str.trim().isEmpty()){
            return false;
        }
        try{
            Integer.parseInt(str);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
