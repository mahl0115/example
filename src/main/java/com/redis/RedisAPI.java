package com.redis;//package com.redis;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import redis.clients.jedis.Jedis;
//
//public class RedisAPI {
//
//    public static void main(String[] args) {
//        Jedis redis = new Jedis("10.11.0.90", 6379);
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("name", "test");
//        map.put("sex", "man");
//        map.put("age", "20");
//        redis.hmset("user", map);
//
//        String name = redis.hget("user", "name");
//
//    }
//}
