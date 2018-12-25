package com.http;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by mahailong on 16/9/5.
 */
public class HttpClientTest {
    public static void main(String[] args) {
//        String url = "http://weibo.com/at/weibo?filter_by_author=0&filter_by_type=0&wvr=6&nofilter=1&pids=plc_main&ajaxpagelet=1&ajaxpagelet_v6=1&__ref=%2Fat%2Fweibo%3Fwvr%3D6%26nofilter%3D1&_t=FM_149145667918651";
//        String str = HttpUtil.httpGet(url);
//        System.out.println("request: \n" + url.toString());
//        System.out.println("response: \n" + str);


        String access_code = "https://api.weibo.com/oauth2/authorize";
        Map<String, String> map = Maps.newHashMap();
        map.put("client_id", "1252908463");
        map.put("redirect_uri", "https://itunes.apple.com/cn");
        //map.put("grant_type", "authorization_code");
        String str = HttpClientUtil.doPost(access_code, map);
        System.out.println("request: \n" + access_code.toString());
        System.out.println("response: \n" + str);
    }
}
