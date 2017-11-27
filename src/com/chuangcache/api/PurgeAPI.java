package com.chuangcache.api;

import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PurgeAPI extends BaseAPI {

    private List<String> DATA_TYPE = Arrays.asList("file", "dir");

    public String purge(String type, Map<String, String> urls) {
        if (StringUtils.isEmpty(type) || !DATA_TYPE.contains(type) || urls == null || urls.isEmpty()) {
            return null;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("api_type", 0);
        map.put("type", type);
        map.put("urls", urls);
        return this.getAPIResult(this.API_BASE_URL + "/content/purge", map);
    }

    public String getPurgeList(String type, String start_time, int page, int page_num) {
        if (StringUtils.isEmpty(type) || !DATA_TYPE.contains(type)) {
            return null;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("type", type);
        if (!StringUtils.isEmpty(start_time)) {
            map.put("start_time", start_time);
        }
        if (page > 0) {
            map.put("page", page);
        }
        map.put("page_num", page_num);
        return this.getAPIResult(this.API_BASE_URL + "/content/getPurgeList", map);
    }
}
