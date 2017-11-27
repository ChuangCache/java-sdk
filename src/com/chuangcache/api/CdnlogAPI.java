package com.chuangcache.api;

import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CdnlogAPI extends BaseAPI {

    public String logfiles(String domain, long startTime, long endTime) {
        if (StringUtils.isEmpty(domain) || startTime <= 0 || endTime <= 0 || startTime > endTime) {
            return null;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("domain", domain);
        map.put("starttime", startTime);
        map.put("endtime", endTime);
        return this.getAPIResult(this.API_BASE_URL + "/cdnlog/logfiles", map);
    }
}
