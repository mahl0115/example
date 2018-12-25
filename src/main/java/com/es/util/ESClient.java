package com.es.util;//package com.es.util;
//
//import java.io.IOException;
//
//import org.elasticsearch.client.Client;
//import org.elasticsearch.client.transport.TransportClient;
//import org.elasticsearch.common.settings.ImmutableSettings;
//import org.elasticsearch.common.settings.Settings;
//import org.elasticsearch.common.transport.InetSocketTransportAddress;
//import org.elasticsearch.common.xcontent.XContentBuilder;
//import org.elasticsearch.common.xcontent.XContentFactory;
//
//import com.es.model.User;
//
//public class ESClient {
//
//    private Client client;
//
//    public void init() {
//        Settings settings = ImmutableSettings.settingsBuilder().put("cluster.name", "baidu-mgame-search").build();
//        client = new TransportClient(settings).addTransportAddress(new InetSocketTransportAddress("10.11.0.90", 9200));
//    }
//
//    public void close() {
//        client.close();
//    }
//
//    /**
//     * index
//     */
//    public void createIndex() {
//        for (int i = 0; i < 1000; i++) {
//            User user = new User();
//            user.setId(i);
//            user.setName("huang fox " + i);
//            user.setAge(i % 100);
//            client.prepareIndex("users", "user").setSource(generateJson(user)).execute().actionGet();
//        }
//    }
//
//    /**
//     * 转换成json对象
//     *
//     * @param user
//     * @return
//     */
//    private String generateJson(User user) {
//        String json = "";
//        try {
//            XContentBuilder contentBuilder = XContentFactory.jsonBuilder().startObject();
//            contentBuilder.field("id", user.getId() + "");
//            contentBuilder.field("name", user.getName());
//            contentBuilder.field("age", user.getAge() + "");
//            json = contentBuilder.endObject().string();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return json;
//    }
//
//    public static void main(String[] args) {
//        ESClient client = new ESClient();
//        client.init();
//        client.createIndex();
//        client.close();
//    }
//
//}
