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


        String url = "http://wx.muyouguoji.com/index.php?g=Wap&m=AdvancedVote&a=show&vote_id=12800&item_id=56775&from=timeline&isappinstalled=0";
        Map<String, String> map = Maps.newHashMap();
        String str = HttpClientUtil.doGet(url, map);
        System.out.println("request: \n" + url.toString());
        System.out.println("response: \n" + str);
    }
}
