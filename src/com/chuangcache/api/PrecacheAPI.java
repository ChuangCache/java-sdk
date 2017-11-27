package com.chuangcache.api;

import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrecacheAPI extends BaseAPI {

    private List<String> DATA_TYPE = Arrays.asList("file", "dir");

    public String precache(Map<String, String> urls) {
        if (urls == null || urls.isEmpty()) {
            return null;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("api_type", 0);
        map.put("urls", urls);
        return this.getAPIResult(this.API_BASE_URL + "/content/precache", map);
    }

    public String getPreCacheList(String start_time, int page, int page_num) {
        Map<String, Object> map = new HashMap<>();
        if (!StringUtils.isEmpty(start_time)) {
            map.put("start_time", start_time);
        }
        if (page > 0) {
            map.put("page", page);
        }
        map.put("page_num", page_num);
        return this.getAPIResult(this.API_BASE_URL + "/content/getPreCacheList", map);
    }
}
