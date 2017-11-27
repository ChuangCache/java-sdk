package com.chuangcache.api;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticsAPI extends BaseAPI {

    public String bandwidth(String domain, long startTime, long endTime, int resultType) {
        return getData("bandwidth", domain, startTime, endTime, resultType);
    }

    public String traffic(String domain, long startTime, long endTime, int resultType) {
        return getData("traffic", domain, startTime, endTime, resultType);
    }

    public String request(String domain, long startTime, long endTime, int resultType) {
        return getData("request", domain, startTime, endTime, resultType);
    }

    private List<String> DATA_TYPE = Arrays.asList("bandwidth", "traffic", "request");

    private String getData(String type, String domain, long startTime, long endTime, int resultType) {
        if (StringUtils.isEmpty(type) || !DATA_TYPE.contains(type) || startTime <= 0 || endTime <= 0 || startTime > endTime) {
            return null;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("type", type);
        if (!StringUtils.isEmpty(domain)) {
            map.put("domain", domain);
        }
        map.put("starttime", startTime);
        map.put("endtime", endTime);
        map.put("resulttype", resultType);
        return this.getAPIResult(this.API_BASE_URL + "/history/getdata", map);
    }
}
