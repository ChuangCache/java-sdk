package com.chuangcache.api;

import java.util.HashMap;
import java.util.Map;

import com.chuangcache.utils.RequestUtil;
import org.apache.commons.lang.StringUtils;

public class Token extends BaseAPI {

    private static String APPID = "APPID";
    private static String APPSECRET = "APPSECRET";
    private static String GRANTTYPE = "client_credentials";

    private String API_URL = this.API_BASE_URL + "/OAuth/authorize";

    /**
     * @var String token
     */
    private static String token = "";

    /**
     * @var long token过期时间
     */
    private static int expires = 0;

    /**
     * 获取token
     *
     * @return
     */
    public String token() {
        long now = System.currentTimeMillis() / 1000;
        if (!StringUtils.isEmpty(this.token) && this.expires > now) {
            return this.token;
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("appid", this.APPID);
        map.put("appsecret", this.APPSECRET);
        map.put("grant_type", this.GRANTTYPE);

        Map<String, Object> result = null;

        try {
            result = RequestUtil.doPost(this.API_URL, map);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

        if (result != null && result.containsKey("status") && ((int) result.get("status")) == 1 && result.get("data") != null) {
            Map<String, Object> data = (Map<String, Object>) result.get("data");
            this.token = (String) data.get("access_token");
            this.expires = (int) data.get("expires_in");
            return this.token;
        }

        return "";
    }

    public static void main(String[] args) {
        Token token = new Token();
        System.out.println(token.token());
    }
}
