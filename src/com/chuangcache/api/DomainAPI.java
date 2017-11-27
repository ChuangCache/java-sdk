package com.chuangcache.api;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class DomainAPI extends BaseAPI {

    /***
     * 获取加速域名列表接口
     * @return
     */
    public String getDomainList() {
        return this.getAPIResult(this.API_BASE_URL + "/domain/domainList", null);
    }

    /***
     * 根据加速域名ID获取加速域名详情接口
     * @param domainId
     * @return
     */
    public String getDomainById(String domainId) {
        if (StringUtils.isEmpty(domainId)) {
            return null;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("domain_id", domainId);
        return this.getAPIResult(this.API_BASE_URL + "/domain/getDomainById", null);
    }

    /***
     * 加速域名添加
     * @param map = {domain, icp_no, cdn_type, data, sourcehost, monitor_url}
     * @return
     */
    public String addDomain(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        if (map.containsKey("domain") || map.containsKey("icp_no") || map.containsKey("cdn_type") || map.containsKey("data") || map.containsKey("monitor_url")) {
            return null;
        }
        return this.getAPIResult(this.API_BASE_URL + "/domain/addDomain", null);
    }
}
