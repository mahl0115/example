//package com.thrift;
//
//import com.thrift.impl.OrderServiceImpl;
//import com.thrift.impl.UserServiceImpl;
//import com.thrift.thrift.TOrderService;
//import com.thrift.thrift.TUserService;
//import org.apache.thrift.TMultiplexedProcessor;
//import org.apache.thrift.TProcessor;
//import org.apache.thrift.protocol.TBinaryProtocol;
//import org.apache.thrift.server.TServer;
//import org.apache.thrift.server.TSimpleServer;
//import org.apache.thrift.server.TThreadPoolServer;
//import org.apache.thrift.transport.TServerSocket;
//
///**
// * Created by mahailong on 16/9/5.
// */
//public class ThriftServerTest {
//    public static void main(String[] args) {
//        startServer();
//    }
//
//    public static void startServer() {
//        try {
//            System.out.println("ThriftServer start...");
//
////            TMultiplexedProcessor multiProcessor = new TMultiplexedProcessor();
////            TProcessor userProcessor = new TUserService.Processor<TUserService.Iface>(
////                    new UserServiceImpl());
////            TProcessor orderProcessor = new TOrderService.Processor<TOrderService.Iface>(
////                    new OrderServiceImpl());
////            multiProcessor.registerProcessor("TUserService", userProcessor);
////            multiProcessor.registerProcessor("TOrderService", orderProcessor);
//            TProcessor userProcessor = new TUserService.Processor<TUserService.Iface>(
//                    new UserServiceImpl());
//            //TSimpleServer服务端-----简单的单线程服务模型，一般用于测试
//            //TThreadPoolServer 服务模型 ------线程池服务模型，使用标准的阻塞式IO，预先创建一组线程处理请求
//            //TNonblockingServer 服务模型  -------使用非阻塞式IO，服务端和客户端需要指定 TFramedTransport 数据传输的方式
//            //THsHaServer服务模型  -------半同步半异步的服务端模型，需要指定为： TFramedTransport 数据传输的方式
//            TServerSocket serverTransport = new TServerSocket(1234);
//            TThreadPoolServer.Args tArgs = new TThreadPoolServer.Args(serverTransport);
//            tArgs.processor(userProcessor);
//            // 数据传输协议
//            //TBinaryProtocol : 二进制格式
//            //TCompactProtocol : 压缩格式
//            //TJSONProtocol : JSON格式
//            //TSimpleJSONProtocol : 提供JSON只写协议, 生成的文件很容易通过脚本语言解析
//            tArgs.protocolFactory(new TBinaryProtocol.Factory());
//            TServer server = new TSimpleServer(tArgs);
//            server.serve();
//
//        } catch (Exception e) {
//            System.out.println("Server start error!!!");
//            e.printStackTrace();
//        }
//    }
//}
