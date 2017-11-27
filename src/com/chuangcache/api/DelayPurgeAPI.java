package com.chuangcache.api;

import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DelayPurgeAPI extends BaseAPI {

    private List<String> DATA_TYPE = Arrays.asList("file", "dir");

    public String delayPurge(String type, Map<String, String> urls, int delay, int is_precache) {
        if (StringUtils.isEmpty(type) || !DATA_TYPE.contains(type) || urls == null || urls.isEmpty()) {
            return null;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("api_type", 0);
        map.put("type", type);
        map.put("urls", urls);
        map.put("delay", delay);
        map.put("is_precache", is_precache);
        return this.getAPIResult(this.API_BASE_URL + "/content/delayPurge", map);
    }

    public String getDelayPurgeList(String task_id, String url_name, String start_time, String end_time, int page, int page_num) {
        Map<String, Object> map = new HashMap<>();
        if (!StringUtils.isEmpty(task_id)) {
            map.put("task_id", task_id);
        }
        if (!StringUtils.isEmpty(url_name)) {
            map.put("url_name", url_name);
        }
        if (!StringUtils.isEmpty(start_time)) {
            map.put("start_time", start_time);
        }
        if (!StringUtils.isEmpty(end_time)) {
            map.put("end_time", end_time);
        }
        if (page > 0) {
            map.put("page", page);
        }
        map.put("page_num", page_num);
        return this.getAPIResult(this.API_BASE_URL + "/content/getDelayPurgeList", map);
    }
}
