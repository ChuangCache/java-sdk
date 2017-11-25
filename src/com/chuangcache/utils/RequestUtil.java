package com.chuangcache.utils;

import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class RequestUtil {

    public static final String API_BASE_URL = "https://api.chuangcache.com";

    /**
     * post请求
     *
     * @param url
     * @param params
     * @return
     */
    public static Map<String, Object> doPost(String url, Map<String, Object> params) throws Exception {
        Map<String, Object> result = null;
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);

        StringEntity entity = new StringEntity(JsonUtil.map2json(params), "utf-8");
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        httpPost.setEntity(entity);

        HttpResponse response = httpClient.execute(httpPost);
        if (response != null) {
            HttpEntity resEntity = response.getEntity();
            if (resEntity != null) {
                result = JsonUtil.json2map(EntityUtils.toString(resEntity, "utf-8"));
            }
        }

        return result;
    }
}
