//package com.memcached;
//
//import java.util.Date;
//import java.util.concurrent.TimeUnit;
//
//import com.danga.MemCached.MemCachedClient;
//import com.danga.MemCached.SockIOPool;
//
//public class MyCache {
//
//    public static void main(String[] args) {
//        MemCachedClient client = new MemCachedClient();
//        String[] addr = { "127.0.0.1:11211" };
//        Integer[] weights = { 3 };
//        // 创建一个Socked连接池实例
//        SockIOPool pool = SockIOPool.getInstance();
//        pool.setServers(addr);
//        // 设置服务器权重
//        pool.setWeights(weights);
//        pool.setInitConn(5);
//        pool.setMinConn(5);
//        pool.setMaxConn(200);
//        pool.setMaxIdle(1000 * 30 * 30);
//        pool.setMaintSleep(30);
//        pool.setNagle(false);
//        pool.setSocketTO(30);
//        pool.setSocketConnectTO(0);
//        pool.initialize();
//
//        // 将数据放入缓存
//        client.set("test2", "test2");
//
//        // 将数据放入缓存,并设置失效时间
//        Date date = new Date(10000);
//        client.set("test1", "test1", new Date(3000));
//
//        // 删除缓存数据
//        // client.delete("test1");
//        try {
//            TimeUnit.SECONDS.sleep(3);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        // 获取缓存数据
//        String str = (String) client.get("test1");
//        System.out.println(str);
//    }
//}
