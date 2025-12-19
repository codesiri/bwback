package com.youlai.boot.common.util;


import com.youlai.boot.common.constant.DvTypeConstants;
import com.youlai.boot.common.util.adapter.IDgenAdapter;
import org.springframework.web.client.RestTemplate;


public class IDgenAdapterLeaf implements IDgenAdapter {
    @Override
    public long genID() {
        RestTemplate restTemplate = SpringApplicationContext.getContext().getBean("restTemplate", RestTemplate.class);
        String dvTypeId = restTemplate.getForObject(DvTypeConstants.REQ_DV_TYPE_ID_URL, String.class);

        return Long.parseLong(dvTypeId);

    }
}
