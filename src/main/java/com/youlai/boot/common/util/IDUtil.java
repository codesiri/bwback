package com.youlai.boot.common.util;

import com.youlai.boot.common.util.adapter.IDgenAdapter;
import com.youlai.boot.ledger.constant.DvLedgerConstants;

public class IDUtil {
    public static long genIdByJdk() {
        IDGenAdapterJDK idGenAdapterJDK = new IDGenAdapterJDK();
        return idGenAdapterJDK.genID(DvLedgerConstants.DV_LEDGER_GEN_ID_URL);
    }

    public static  long genIdByLeaf(){
        IDgenAdapter iDgenAdapter = new IDgenAdapterLeaf();
        //生成id
        return iDgenAdapter.genID(DvLedgerConstants.DV_LEDGER_GEN_ID_URL);
    }
}
