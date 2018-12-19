//package com.thrift;
//
//import com.thrift.thrift.TOrderService;
//import com.thrift.thrift.TUser;
//import com.thrift.thrift.TUserService;
//import org.apache.thrift.TException;
//import org.apache.thrift.protocol.TBinaryProtocol;
//import org.apache.thrift.protocol.TProtocol;
//import org.apache.thrift.transport.*;
//
//import java.lang.reflect.Constructor;
//import java.lang.reflect.InvocationTargetException;
//
///**
// * Created by mahailong on 16/9/5.
// */
//public class ThriftClientTest {
//    public static void main(String[] args) throws TException, InstantiationException, IllegalAccessException {
//        TUserService.Client client = getInterface(TUserService.Client.class);
//        TUser user = new TUser();
//        user.setUserName("root");
//        user.setPassword("root");
//        boolean flag = client.login(user);
//        System.out.println("Login : " + flag);
//
//        client.getInputProtocol().getTransport().close();
//
//    }
//
//    public static <T> T getInterface(Class<T> clazz) throws IllegalAccessException, InstantiationException {
//        TTransport transport = null;
//        T t = null;
//        try {
//            transport = new TSocket("localhost", 1234);
//            //transport = new TFramedTransport(new TSocket("localhost", 1234));
//            // 数据传输协议
//            // 协议要和服务端一致
//            TProtocol protocol = new TBinaryProtocol(transport);
//            //TProtocol protocol = new TCompactProtocol(transport);
//            // TProtocol protocol = new TJSONProtocol(transport);
//            Constructor con = clazz.getConstructor(TProtocol.class);
//            t = (T) con.newInstance(protocol);
//            transport.open();
//
//        } catch (TTransportException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
////        finally {
////            if (null != transport) {
////                transport.close();
////            }
////        }
//        return t;
//    }
//}
