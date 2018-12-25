package com.zk.unpackage;//package com.zk.unpackage;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.concurrent.CountDownLatch;
//
//import org.apache.zookeeper.CreateMode;
//import org.apache.zookeeper.KeeperException;
//import org.apache.zookeeper.WatchedEvent;
//import org.apache.zookeeper.Watcher;
//import org.apache.zookeeper.Watcher.Event.KeeperState;
//import org.apache.zookeeper.ZooDefs.Ids;
//import org.apache.zookeeper.ZooKeeper;
//
//public class ZookeeperDemo implements Watcher {
//
//    private static List<String> nodeList;// 所要监控的结点的子结点列表
//    public static final String PATH = "/mynode";// 所要监控的结点
//    private static ZooKeeper zk;
//    private static CountDownLatch cdl = new CountDownLatch(1);
//
//    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
//
//        Watcher watcher = new ZookeeperDemo();
//        zk = new ZooKeeper("127.0.0.1:2181", 5000, watcher);
//        // cdl.await();
//
//        String path1 = "/zk-test1";
//        zk.create(path1, "".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
//        System.out.println("success create znode " + path1);
//
//        String path2 = "/zk-test2";
//        zk.create(path2, "".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
//        System.out.println("success create znode " + path2);
//    }
//
//    @Override
//    public void process(WatchedEvent event) {
//        if (KeeperState.SyncConnected == event.getState()) {
//            cdl.countDown();// 最好放在finally当中
//        }
//    }
//}
