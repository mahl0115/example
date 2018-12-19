package com.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mahailong on 17/4/6.
 */
public class CurlTest {

    public static void main(String[] args) throws IOException {
        String[] cmds = {"curl", "-H", "Cookie: SUB=_2A2514aL2DeThGeVM6VUZ9CjOzj2IHXVWlpM-rDV8PUNbmtAKLUXZkW8e2Tf_yvLGBlDsCj8e23qG8YXR0w..;", "--compressed", "http://weibo.com/at/weibo?filter_by_author=0&filter_by_type=0&wvr=6&nofilter=1&pids=plc_main&ajaxpagelet=1&ajaxpagelet_v6=1&__ref=%2Fat%2Fweibo%3Ffilter_by_author%3D0%26filter_by_type%3D0%26wvr%3D6%26nofilter%3D1&_t=FM_149145667918666"};
        ProcessBuilder pb = new ProcessBuilder(cmds);
        pb.redirectErrorStream(true);
        Process p = pb.start();

        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println("\t" + line);
        }
        br.close();

    }
}
