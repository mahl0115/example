package com.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil {

    public static String http(String url, String params) {
        URL u = null;
        HttpURLConnection con = null;
        StringBuilder sb = new StringBuilder(params);
        try {
            u = new URL(url);
            con = (HttpURLConnection) u.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setUseCaches(false);
            //con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.setRequestProperty("Cookie", "SUB=_2A2514aL2DeThGeVM6VUZ9CjOzj2IHXVWlpM-rDV8PUNbmtAKLUXZkW8e2Tf_yvLGBlDsCj8e23qG8YXR0w..");
            OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream(), "UTF-8");
            osw.write(sb.toString());
            osw.flush();
            osw.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }
        
        StringBuffer buffer = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            String temp;
            while ((temp = br.readLine()) != null) {
                buffer.append(temp);
                buffer.append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("response context:" + buffer.toString());
        return buffer.toString();
    }

    public static String httpGet(String url) {
        URL u = null;
        HttpURLConnection con = null;
        // StringBuilder sb = new StringBuilder(params);
        try {
            u = new URL(url);
            con = (HttpURLConnection) u.openConnection();
            con.setRequestMethod("GET");
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setUseCaches(false);
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.setRequestProperty("Cookie", "SUB=_2A2514aL2DeThGeVM6VUZ9CjOzj2IHXVWlpM-rDV8PUNbmtAKLUXZkW8e2Tf_yvLGBlDsCj8e23qG8YXR0w..");
            // OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream(), "UTF-8");
            // osw.write(sb.toString());
            // osw.flush();
            // osw.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }

        StringBuffer buffer = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            String temp;
            while ((temp = br.readLine()) != null) {
                buffer.append(temp);
                buffer.append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println("response context:" + buffer.toString());
        return buffer.toString();
    }

}