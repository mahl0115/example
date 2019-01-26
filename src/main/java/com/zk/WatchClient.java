package com.zk;//package com.zk;
//
//import java.io.IOException;
//import java.util.List;
//
//public class WatchClient extends Thread {
//
//    public static final int CLIENT_PORT = 2181;
//    public static final String PATH = "/app1";// 所要监控的结点
//    private static ZooKeeper zk;
//    private static List<String> nodeList;// 所要监控的结点的子结点列表
//
//    public static void main(String[] args) throws Exception {
//        new WatchClient();
//        WatchClient th = new WatchClient();
//        th.start();
//    }
//
//    public WatchClient() throws IOException {
//
//        zk = new ZooKeeper("127.0.0.1:" + CLIENT_PORT, 5000, new Watcher() {
//            public void process(WatchedEvent event) {
//            }
//        });
//    }
//
//    /**
//     * 设置watch的线程
//     */
//    @Override
//    public void run() {
//        Watcher wc = new Watcher() {
//            @Override
//            public void process(WatchedEvent event) {
//                // 结点数据改变之前的结点列表
//                List<String> nodeListBefore = nodeList;
//                // 主结点的数据发生改变时
//                if (event.getType() == EventType.NodeDataChanged) {
//                    System.out.println("Node data changed:" + event.getPath());
//                }
//                if (event.getType() == EventType.NodeDeleted) {
//                    System.out.println("Node deleted:" + event.getPath());
//                }
//                if (event.getType() == EventType.NodeCreated) {
//                    System.out.println("Node created:" + event.getPath());
//                }
//
//                // 获取更新后的nodelist
//                try {
//                    nodeList = zk.getChildren(event.getPath(), false);
//                } catch (KeeperException e) {
//                    System.out.println(event.getPath() + " has no child, deleted.");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                List<String> nodeListNow = nodeList;
//                // 增加结点
//                if (nodeListBefore.size() < nodeListNow.size()) {
//                    for (String str : nodeListNow) {
//                        if (!nodeListBefore.contains(str)) {
//                            System.out.println("Node created:" + event.getPath() + "/" + str);
//                        }
//                    }
//                }
//            }
//        };
//
//        /**
//         * 持续监控PATH下的结点
//         */
//        while (true) {
//            System.out.println("开始执行...");
//            try {
//                zk.exists(PATH, wc);// 所要监控的主结点
//            } catch (KeeperException | InterruptedException e) {
//                e.printStackTrace();
//            }
//            try {
//                nodeList = zk.getChildren(PATH, wc);
//            } catch (KeeperException | InterruptedException e) {
//                e.printStackTrace();
//            }
//            // 对PATH下的每个结点都设置一个watcher
//
//            for (String nodeName : nodeList) {
//                try {
//                    zk.exists(PATH + "/" + nodeName, wc);
//                } catch (KeeperException | InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            try {
//                Thread.sleep(3000);// sleep一会，减少CUP占用率
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("执行结束...");
//        }
//
//    }
//}
