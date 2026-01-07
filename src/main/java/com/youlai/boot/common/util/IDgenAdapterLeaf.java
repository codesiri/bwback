package com.youlai.boot.common.util;


import com.youlai.boot.common.util.adapter.IDgenAdapter;
import org.springframework.web.client.RestTemplate;


public class IDgenAdapterLeaf implements IDgenAdapter {
    @Override
    public long genID(String key) {
        RestTemplate restTemplate = SpringApplicationContext.getContext().getBean("restTemplate", RestTemplate.class);
        String dvTypeId = restTemplate.getForObject(key, String.class);
        return Long.parseLong(dvTypeId);

    }
}
