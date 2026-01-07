package com.youlai.boot.common.util;

import com.youlai.boot.common.util.adapter.IDgenAdapter;

public class IDGenAdapterJDK  implements IDgenAdapter {


    @Override
    public long genID(String key) {
        long start = 2;
        synchronized (IDGenAdapterJDK.class){
            start = start ++;
        }
        return start;
    }
}
