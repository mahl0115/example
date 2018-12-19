//package com.zk;
//
//import java.io.IOException;
//
//import org.I0Itec.zkclient.IZkDataListener;
//import org.I0Itec.zkclient.ZkClient;
//
//public class ZookeeperDemo {
//
//    // private static CountDownLatch connectedSemaphore = new CountDownLatch(1);
//
//    public static void main(String[] args) throws IOException, InterruptedException {
//        // 连接
//        ZkClient client = new ZkClient("127.0.0.1:2181", 5000);
//        // 创建节点
//        String path = "/zk-test";
//        // true表示递归创建父节点
//        // client.createPersistent(path, true);
//        client.createEphemeral(path, "zk-test");
//
//        client.subscribeDataChanges(path, new IZkDataListener() {
//
//            @Override
//            public void handleDataDeleted(String dataPath) throws Exception {
//                System.out.println("Data on Node " + dataPath + " deleted");
//            }
//
//            @Override
//            public void handleDataChange(String dataPath, Object data) throws Exception {
//                System.out.println("Data on Node " + dataPath + " changed, new data: " + data);
//            }
//
//        });
//
//        System.out.println(client.readData(path));
//        client.writeData(path, "0");
//        Thread.sleep(1000);
//        // client.delete(path);
//        // Thread.sleep(1000);
//    }
//
//}
