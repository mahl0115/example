package com.thrift.impl;//package com.thrift.impl;
//
//import com.thrift.thrift.TOrder;
//import com.thrift.thrift.TOrderService;
//import org.apache.thrift.TException;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by mahailong on 16/9/7.
// */
//public class OrderServiceImpl implements TOrderService.Iface {
//    @Override
//    public List<TOrder> getOrdersByUserId(int userId) throws TException {
//        List<TOrder> orders = new ArrayList<TOrder>();
//        orders.add(new TOrder().setTitle("面包"));
//        orders.add(new TOrder().setTitle("薯条"));
//        return orders;
//    }
//
//    @Override
//    public TOrder getOrderByOrderNumber(String orderNumber) throws TException {
//        TOrder order = new TOrder();
//        order.setTitle("苹果");
//        return order;
//    }
//
//    @Override
//    public List<TOrder> getOrdersByStatus(int status) throws TException {
//        List<TOrder> orders = new ArrayList<TOrder>();
//        orders.add(new TOrder().setTitle("篮球"));
//        orders.add(new TOrder().setTitle("足球"));
//        return orders;
//    }
//}
