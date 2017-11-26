package com.chuangcache.api;

import com.chuangcache.utils.JsonUtil;
import com.chuangcache.utils.RequestUtil;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class BaseAPI {

    protected String API_BASE_URL = "https://api.chuangcache.com";

    protected String getAPIResult(String url, Map<String, Object> map) {
        String access_token = (new Token()).token();
        if (StringUtils.isEmpty(access_token)) {
            return null;
        }
        if (map == null) {
            map = new LinkedHashMap<>();
        }
        map.put("access_token", access_token);

        Map<String, Object> result = null;

        try {
            result = RequestUtil.doPost(url, map);
            return JsonUtil.map2json(result);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
